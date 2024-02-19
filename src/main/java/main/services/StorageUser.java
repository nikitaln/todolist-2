package main.services;

import main.dto.User;

import java.util.ArrayList;
import java.util.List;

public class StorageUser {

    private List<User> users = new ArrayList<>();


    public void addUser(User user) {
        System.out.println("user add to storage");
        users.add(user);
    }

}
