/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import dao.userMapper;
import service.UserService;
import java.util.Scanner;
import static util.textColor.*;

/**
 *
 * @author YoonEn
 */
public class user2Controller {

    private userMapper<User> userList = new UserService<>();
    private Scanner input = new Scanner(System.in);

    public void hardCodeUser() {
        userList.add(new User("abc", "123"));
        userList.add(new User("def", "456"));
        userList.add(new User("ghi", "789"));
        userList.add(new User("jkl", "012"));
    }
    
    public void characterInput() {
        while (!input.hasNextInt()) {
            System.out.println(TEXT_RED + "Error: Can only accept integer.\n" + TEXT_RESET);
            System.out.print("Please enter option to proceed: ");
            input.next();
        }
    }

    public void userMenu() {
        hardCodeUser();
        int selection = 0;
        while (selection != 4) {
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|        Menu        |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|    1. Register     |");
            System.out.println("|    2. Login        |");
            System.out.println("|    3. User List    |");
            System.out.println("|    4. Exit         |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.print("Please enter option to proceed: ");
            characterInput();
            selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    registration();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    break;
                default:
                    System.out.println(TEXT_RED + "Error: Option Not Found, Plese Try Again." + TEXT_RESET);

            }
        }
    }

    public void userMenu2() {
        int selection = 0;
        while (selection != 2) {
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|        Menu        |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|    1. Wishlist     |");
            System.out.println("|    2. Logout       |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.print("Please enter option to proceed: ");
            characterInput();
            selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    wishlist();
                    break;
                case 2:
                    break;
                default:
                    System.out.println(TEXT_RED + "Option Not Found, Plese Try Again." + TEXT_RESET);

            }
        }
    }

    public void wishlistMenu() {
        int selection = 0;
        while (selection != 3) {
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|     Manage Wishlist    |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|    1. Add Product      |");
            System.out.println("|    2. Remove Product   |");
            System.out.println("|    3. Exit             |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.print("Please enter option to proceed: ");
            characterInput();
            selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    addWishlist();
                    break;
                case 2:
                    removeWishlist();
                    break;
                case 3:
                    break;
                default:
                    System.out.println(TEXT_RED + "Option Not Found, Plese Try Again." + TEXT_RESET);

            }
        }
    }

    public void registration() {
        int n = 0;

        System.out.println("\n------------------------------");
        System.out.println(TEXT_BLUE + "         Registration         " + TEXT_RESET);
        System.out.println("------------------------------");
        System.out.print("Username         : ");
        String username = input.nextLine();
        while ("".equals(username)) {
            System.out.println(TEXT_RED + "Error: Username cannot be empty.\n" + TEXT_RESET);
            System.out.print("Username         : ");
            username = input.nextLine();
        }
        for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
            String mn = userList.getEntry(i).getUsername();
            if (mn.equals(username)) {
                n++;
            }
        }
        if (n != 0) {
            System.out.println(TEXT_RED + "\nError: [" + username + "] registered before." + TEXT_RESET);
        } else {
            String password;
            String confirmpassword;
            do {
                System.out.print("Password         : ");
                password = input.nextLine();
                while ("".equals(password)) {
                    System.out.println(TEXT_RED + "Error: Password cannot be empty.\n" + TEXT_RESET);
                    System.out.print("Password         : ");
                    password = input.nextLine();
                }
                System.out.print("Confirm Password : ");
                confirmpassword = input.nextLine();
                if (!(password).equals(confirmpassword)) {
                    System.out.println(
                            TEXT_RED + "Error: Confirm password not same with password, pls reenter password again.\n"
                            + TEXT_RESET);
                }
            } while (!(password).equals(confirmpassword));
            User s = new User(username, password);
            if (userList.add(s)) {
                System.out.println(
                        TEXT_GREEN + "\nAccount for [" + username + "] has been registered successfully." + TEXT_RESET);
            }
        }
    }

    public void login() {

        System.out.println("\n------------------------------");
        System.out.println(TEXT_BLUE + "             Login            " + TEXT_RESET);
        System.out.println("------------------------------");
        System.out.print("Username         : ");
        String username = input.nextLine();
        while ("".equals(username)) {
            System.out.println(TEXT_RED + "Error: Username cannot be empty.\n" + TEXT_RESET);
            System.out.print("Username         : ");
            username = input.nextLine();
        }
        System.out.print("Password         : ");
        String password = input.nextLine();
        while ("".equals(password)) {
            System.out.println(TEXT_RED + "Error: Password cannot be empty.\n" + TEXT_RESET);
            System.out.print("Password         : ");
            password = input.nextLine();
        }
        User login = new User(username, password);
        if (!userList.contains(login)) {
            System.out.println(TEXT_RED + "\nError: Wrong username or password." + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "\nSuccessfully login." + TEXT_RESET);
            userMenu2();
        }
    }

    public void displayList() {
        if (userList.isEmpty()) {
            System.out.println(TEXT_GREEN + "No user found." + TEXT_RESET);
        } else {
            System.out.println(TEXT_BLUE + "\n                User List                " + TEXT_RESET);
            System.out.println("============================================\n"
                    + "   Username             Password            \n"
                    + "============================================");
            for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
                System.out.printf(i + ". " + userList.getEntry(i).toString2() + "\n");
            }
            System.out.println("============================================");
        }
    }

    public void wishlist() {
        //if (userList.isEmpty()) {
        //    System.out.println(TEXT_GREEN + "No user found." + TEXT_RESET);
        //} else {
        System.out.println(TEXT_BLUE + "\n                Wish List                " + TEXT_RESET);
        System.out.println("============================================\n"
                + "   Product         Quantity         Price   \n"
                + "============================================");
        //    for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
        //        System.out.printf(i + ". " + userList.getEntry(i).toString2() + "\n");
        //    }
        System.out.println("============================================");
        //}
        wishlistMenu();
    }

    public void addWishlist() {

    }

    public void removeWishlist() {

    }

    public void reset() {
        int n = 0;
        hardCodeUser();

        System.out.println("         Reset password         ");
        System.out.println("--------------------------------");

        System.out.print("Username         : ");
        String username = input.nextLine();
        while ("".equals(username)) {
            System.out.println(TEXT_RED + "Error: Username cannot be empty.\n" + TEXT_RESET);
            System.out.print("Username         : ");
            username = input.nextLine();
        }
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
                System.out.print("Password         : ");
                password = input.nextLine();
                while ("".equals(password)) {
                    System.out.println(TEXT_RED + "Error: Password cannot be empty.\n" + TEXT_RESET);
                    System.out.print("Password         : ");
                    password = input.nextLine();
                }
                System.out.print("Confirm Password : ");
                confirmpassword = input.nextLine();
                if (!(password).equals(confirmpassword)) {
                    System.out.println(
                            TEXT_RED + "Error: Confirm password not same with password, pls reenter password again.\n"
                            + TEXT_RESET);
                }
            } while (!(password).equals(confirmpassword));

            for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
                String us = userList.getEntry(i).getUsername();
                String pa = userList.getEntry(i).getPassword();
                User resetUser = new User(us, pa);

                if (username.equals(us)) {
                    userList.remove(resetUser);
                }

            }
            User addUser = new User(username, password);
            if (userList.add(addUser)) {
                System.out.println(
                        TEXT_GREEN + "\nAccount for [" + username + "] has been reset successfully." + TEXT_RESET);
                for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
                    String us = userList.getEntry(i).getUsername();
                    String pa = userList.getEntry(i).getPassword();

                    System.out.println("final" + ":" + us + "," + pa);

                }
            }
        } else {

            System.out.println(TEXT_RED + "\nError: [" + username + "] user not found." + TEXT_RESET);

        }
        System.out.print("\n");
    }

}
