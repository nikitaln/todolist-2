package main.controller;

import main.dto.User;
import main.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "todo")
public class LoginController {

    @Autowired                  //тоже самое что LoginService ls = new LoginService();
    LoginService loginService;
    private final Logger logger = LogManager.getLogger(LoginController.class);


    @GetMapping()
    public String loginPage() {
        logger.info("GET login_page.html");
        return "login_page";
    }


    @PostMapping(value = "/login")
    public String login(User user) {
        logger.info("POST /login authentication");

        if (loginService.auth(user)) {

            return "redirect:/tasks";
        }
        return "login_page";
    }


    @PostMapping(value = "/reg")
    public String reg() {
        logger.info("POST /reg registration");
        return "redirect:/reg";
    }
}
