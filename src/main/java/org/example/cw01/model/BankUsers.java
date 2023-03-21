package org.example.cw01.model;

import java.util.ArrayList;
import java.util.List;

public class BankUsers {
    private List<User> userList = new ArrayList<>();

    public void initUser(List<User> userList) {
        this.userList = userList;
    }

    public User getUser(String name) {
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) return user;
        }
        return new User("Такого пользователя нет");
    }
}
