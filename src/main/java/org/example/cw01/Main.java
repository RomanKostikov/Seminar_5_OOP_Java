package org.example.cw01;

import org.example.cw01.model.BankUsers;
import org.example.cw01.model.Company;
import org.example.cw01.model.Human;
import org.example.cw01.model.User;
import org.example.cw01.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Классы различных пользователей 2-3
// Класс в сервисе, рассматривающий заявки на кредитование

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter name");
//        String name = scanner.nextLine();
//        System.out.println("enter age");
//        int age = scanner.nextInt();
//        System.out.println("enter salary");
//        float salary = scanner.nextInt();
        UserView userView = new UserView();
//        userView.saveUser(name,age,salary);

        BankUsers users = new BankUsers();
        users.initUser(List.of(new Human("Human1", false, 1000, 30, 50000),
                new Human("Human2", true, 100, 35, 40000),
                new Company("Company1", false, 100000, 77777),
                new Company("Company2", true, 40000, 88888)));
        userView.creditPrint(users.getUser("Human1"), 400);

    }


}
