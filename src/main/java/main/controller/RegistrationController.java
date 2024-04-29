package main.controller;


import main.dto.Statistics;
import main.dto.User;
import main.repositories.UserRepository;
import main.services.StatisticsService;
import main.services.StorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


@Controller
@RequestMapping(value = "reg")
public class RegistrationController {


    UserRepository userRepository;
    StatisticsService statisticsService;
    StorageService storageService;

    private final Logger logger = LogManager.getLogger(RegistrationController.class);

    @Autowired
    public RegistrationController(UserRepository userRepository, StatisticsService statisticsService, StorageService storageService) {
        this.userRepository = userRepository;
        this.statisticsService = statisticsService;
        this.storageService = storageService;
    }

    @GetMapping
    public String registrationForm() {
        logger.info("GET registration_page.html");

        return "registration_page";
    }


    @PostMapping(value = "/save")
    public String registration(User user, @RequestParam("file") MultipartFile file) throws IOException {
        logger.info("POST /save create user and save to database");
        user.setRegistrationDate(LocalDate.now());
        Statistics statistics = statisticsService.createNewStatistics(user);
        user.setStatistics(statistics);


        try {
            String pathImage = storageService.savePersonalImage(user, file);
            user.setImage(pathImage);
            userRepository.save(user);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/todo";
    }


    //@RequestParam("file") - "file" соответствует name="file" в атрибутах HTML
//    @PostMapping(value = "/upload")
//    public String uploadImage(@RequestParam("file") MultipartFile file) {
//        System.out.println("Файл - " + file.getOriginalFilename() + ", размер - " + file.getSize());
//        try {
//            storageService.savePersonalImage(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "redirect:/todo";
//    }

}
