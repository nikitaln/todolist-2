package main.services;

import main.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private String userEmail = "root@ya.ru";
    private String password = "1234";


    public boolean auth(User user) {
        System.out.println("check email and pass");
        return user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(password);
    }

}
