package controller;

import java.util.Scanner;
import entity.User;
import java.util.ArrayList;

public class UserController {
    public void resetPassword() {

        String password;

        System.out.print("Enter your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        if (true) {
            System.out.print("Enter your new password: ");
            String temp = sc.nextLine();
            password = temp;
        }

    }
}
