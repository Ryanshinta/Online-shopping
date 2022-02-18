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

    private userMapper<User> userList = new UserService<>();

    public void hardCodeUser() {
        userList.add(new User("abc", "123"));
        userList.add(new User("def", "456"));
        userList.add(new User("ghi", "789"));
        userList.add(new User("jkl", "012"));
    }

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
                    System.out.println(TEXT_RED + "Error: Password cannot be empty.\n" + TEXT_RESET);
                    System.out.print("Password         : ");
                    password = sc.nextLine();
                }
                System.out.print("Confirm new password : ");
                confirmpassword = sc.nextLine();
                if (!(password).equals(confirmpassword)) {
                    System.out.println(
                            TEXT_RED + "Error: password is different, pls reenter password again.\n"
                                    + TEXT_RESET);
                }
            } while (!(password).equals(confirmpassword));
            User s = new User(username, password);
            if (userList.add(s)) {
                System.out.println(
                        TEXT_GREEN + "\nPassword for [" + username + "] has been reset successfully." + TEXT_RESET);
            }
        } else {
            System.out.println(TEXT_RED + "\nError: [" + username + "] cant find." + TEXT_RESET);

        }

    }
}
