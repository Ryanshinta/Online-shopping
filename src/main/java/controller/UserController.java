package controller;

import java.util.Scanner;
import entity.User;
import java.util.ArrayList;
import entity.User;
import dao.userMapper;
import service.UserService;
import java.util.Scanner;
import static util.textColor.*;

public class UserController {

    public static ArrayList<String> usernames = new ArrayList<String>();
    public static ArrayList<String> passwords = new ArrayList<String>();
    private userMapper<User> userList = new UserService<>();

    public void resetPassword() {
        int n = 0;

        System.out.print("Enter your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        // usernames.add(username);
        for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
            String mn = userList.getEntry(i).getUsername();
            if (mn.equals(username)) {
                n++;
            }
        }
        if (n != 0) {
            String password;
            String confirmpassword;
            do {
                System.out.print("Enter new password: ");
                password = sc.nextLine();
                while ("".equals(password)) {
                    System.out.println("Error: Password cannot be empty.\n");
                    System.out.print("Password         : ");
                    password = sc.nextLine();
                }
                System.out.print("Confirm new password : ");
                confirmpassword = sc.nextLine();
                if (!(password).equals(confirmpassword)) {
                    System.out.println(
                            "Error: password is different, pls reenter password again.\n");
                }
            } while (!(password).equals(confirmpassword));
            User s = new User(username, password);
            if (userList.add(s)) {
                System.out.println(
                        "\nPassword for [" + username + "] has been reset successfully.");
            }
        } else {
            System.out.println("\nError: [" + username + "] cant find.");

        }

    }
}
