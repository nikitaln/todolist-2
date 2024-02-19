package main.controller;


import main.dto.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "reg")
public class RegistrationController {

    UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registrationForm() {
        System.out.println("reg_page controller");
        return "registration_page";
    }

    @PostMapping(value = "/save")
    public String registration(User user) {
        userRepository.save(user);
        System.out.println("user create in DB");
        return "redirect:/todo";
    }

}
