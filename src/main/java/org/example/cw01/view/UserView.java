package org.example.cw01.view;

import org.example.cw01.model.User;
import org.example.cw01.service.UserService;
import org.example.cw01.service.UserServiceImpl;

public class UserView {
    private UserService userService = new UserServiceImpl();

    public void saveUser(String name, int age, float salary) {
        userService.save(new User(name));
    }

    public void creditPrint(User user, int creditSum) {
        System.out.println(userService.credit(user, creditSum));
    }
}
