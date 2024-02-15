package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "todo")
public class LoginController {


    @GetMapping()
    public String loginPage() {

        return "login_page";
    }


    @PostMapping(value = "/login")
    public String login(User user) {
        System.out.println("login controller");
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPassword());
        return "redirect:/tasks";
    }



}
