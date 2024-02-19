package main.controller;

import main.dto.User;
import main.services.LoginService;
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

    @GetMapping()
    public String loginPage() {
        return "login_page";
    }


    @PostMapping(value = "/login")
    public String login(User user) {
        System.out.println("login controller");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        if (loginService.auth(user)) {
            return "redirect:/tasks";
        }
        return "login_page";
    }

    @PostMapping(value = "/reg")
    public String reg() {
        System.out.println("click registration");
        return "redirect:/reg";
    }
}
