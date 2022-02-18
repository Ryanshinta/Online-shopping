package controller;

import java.util.Scanner;
import java.util.ArrayList;

public class UserController {

    public static ArrayList<String> usernames = new ArrayList<String>();
    public static ArrayList<String> passwords = new ArrayList<String>();
    // public static ArrayList<User> test = new ArrayList<User>();

    // interface User {
    // String username = "a";
    // String password = "123";

    // }

    public void hardCode() {
        usernames.add("a");
        usernames.add("abc");
        usernames.add("c");

        passwords.add("123");
        passwords.add("456");
        passwords.add("789");
    }

    public void resetPassword() {
        hardCode();
        System.out.print("Enter your username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        if (usernames.contains(username)) {
            System.out.print("Enter your new password: ");
            String password = sc.nextLine();

            passwords.add(password);
            System.out.println("new password reset successfully");

            // System.out.print("username after changes:" + usernames.toString());
            // System.out.print("password after changes:" + passwords.toString());
        } else {
            System.out.print("username not found ");

        }

    }
}
