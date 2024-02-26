package main.services;

import main.dto.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private UserRepository userRepository;
    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean auth(User user) {
        String email = user.getEmail();
        String pass = user.getPassword();

        List<User> usersFromDb = getAllUsersFromDb();

        for (int i = 0; i < usersFromDb.size(); i++) {
            if (usersFromDb.get(i).getEmail().equals(email) && usersFromDb.get(i).getPassword().equals(pass)) {

                return true;
            }
        }

        return false;
    }


    public  List<User> getAllUsersFromDb() {
        return userRepository.findAll();
    }

}
