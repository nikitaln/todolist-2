package main.controller;


import main.dto.Statistics;
import main.dto.User;
import main.repositories.UserRepository;
import main.services.StatisticsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Controller
@RequestMapping(value = "reg")
public class RegistrationController {


    UserRepository userRepository;
    StatisticsService statisticsService;

    private final Logger logger = LogManager.getLogger(RegistrationController.class);


    @Autowired
    public RegistrationController(UserRepository userRepository, StatisticsService statisticsService) {
        this.userRepository = userRepository;
        this.statisticsService = statisticsService;
    }


    @GetMapping
    public String registrationForm() {
        logger.info("GET registration_page.html");

        return "registration_page";
    }


    @PostMapping(value = "/save")
    public String registration(User user) {
        logger.info("POST /save create user and save to database");
        user.setRegistrationDate(LocalDate.now());
        Statistics statistics = statisticsService.createNewStatistics(user);
        user.setStatistics(statistics);
        userRepository.save(user);

        return "redirect:/todo";
    }


    //@RequestParam("file") - "file" соответствует name="file" в атрибутах HTML
    @PostMapping(value = "/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        System.out.println("Файл - " + file.getOriginalFilename() + ", размер - " + file.getSize());

        return "redirect:/todo";
    }

}
