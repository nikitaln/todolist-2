package main.controller;

import main.repositories.TaskRepository;
import main.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    private final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping()
    public String getUsers(Model model) {
        logger.info("GET /tasks returns users_page.html");

        model.addAttribute("usersFromDb", userRepository.findAll());
        model.addAttribute("usersCount", userRepository.count());
        model.addAttribute("users", userRepository.findAll());

        return "users_page";
    }
}
