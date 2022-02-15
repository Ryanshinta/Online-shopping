package controller;

import java.util.Scanner;
import entity.User;
import java.util.ArrayList;

public class UserController {

    public static ArrayList<String> usernames = new ArrayList<String>();
    public static ArrayList<String> passwords = new ArrayList<String>();

    public void resetPassword() {

        System.out.print("Enter your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        usernames.add(username);

        if (true) {
            System.out.print("Enter your new password: ");
            String password = sc.nextLine();
            passwords.add(password);
        }

    }
}
