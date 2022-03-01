/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import dao.userMapper;
import entity.item;
import service.ItemService;
import service.UserService;

import java.util.ArrayList;
import java.util.Scanner;
import static util.textColor.*;

/**
 *
 * @author YoonEn,Ouyang(Wish List)
 */
public class userController {

    private userMapper userList = new UserService();
    private ItemService itemService = new ItemService();
    private Scanner input = new Scanner(System.in);
    private User CurrentUser = null;

    public void hardCodeUser() {
        userList.newUser(new User("abc", "123"));
        userList.newUser(new User("def", "456"));
        userList.newUser(new User("ghi", "789"));
        userList.newUser(new User("jkl", "012"));
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
            System.out.println(TEXT_BLUE+"\nCurrent User:"+CurrentUser.getUsername()+TEXT_RESET);
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
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
                    logout();
                    break;
                default:
                    System.out.println(TEXT_RED + "Option Not Found, Plese Try Again." + TEXT_RESET);

            }
        }
    }
    public void logout(){
        CurrentUser = null;
        System.out.println(TEXT_GREEN+"Log out successfully"+TEXT_RESET);
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
        if (userList.searchByUsernameBoolean(username)) {
            n++;
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
            if (userList.newUser(s)) {
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
        if (!userList.containUser(login)) {
            System.out.println(TEXT_RED + "\nError: Wrong username or password." + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "\nSuccessfully login." + TEXT_RESET);
            CurrentUser = login;
            userMenu2();
        }
    }

    public void displayList() {
        if (userList.displayAllUser() == null) {
            System.out.println(TEXT_GREEN + "No user found." + TEXT_RESET);
        } else {
            System.out.println(TEXT_BLUE + "\n                User List                " + TEXT_RESET);
            System.out.println("=============================================\n"
                    + "    Username             Password            \n"
                    + "=============================================");
            System.out.printf(userList.displayAllUser() + "\n");

            System.out.println("============================================");
        }
    }

    public void wishlist() {
        displayWishList();
        wishlistMenu();

    }

    public void addWishlist() {
        System.out.println(TEXT_BLUE + "\n                Wish List                " + TEXT_RESET);
        System.out.println(
                          "====================================================================\n"
                        + "ID       Product Name           Desc                       Price   \n"
                        + "====================================================================");
        for (item i : itemService.displayAllItem().values()) {
            System.out.printf("%-8d %-15s        %-25s  RM %.2f \n",
                            i.getItemID(), i.getItemName() ,i.getItemDesc() ,i.getItemPrice());
        }

        System.out.println("Please enter The Item ID to proceed: ");
        Integer ItemID = input.nextInt();
        try {
           item i =  itemService.searchById(ItemID);
           CurrentUser.getWishList().add(i);
            System.out.println(TEXT_GREEN + "\nSuccessfully Add." + TEXT_RESET);
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public void displayWishList(){
        if (CurrentUser.getWishList().size() == 0){
            System.out.println(TEXT_GREEN + "No wish list found." + TEXT_RESET);
        }else {

            System.out.println(TEXT_BLUE + "\n                Wish List                " + TEXT_RESET);
            System.out.println(
                    "====================================================================\n"
                            + "ID       Product Name           Desc                       Price   \n"
                            + "====================================================================");
            for(int i = 0; i < CurrentUser.getWishList().size(); i++) {
                item n = (item) CurrentUser.getWishList().get(i);
                System.out.printf("%-8d %-15s        %-25s  RM %.2f \n",
                        n.getItemID(),n.getItemName(),n.getItemDesc(),n.getItemPrice());
            }


        }
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
        if (userList.searchByUsernameBoolean(username)) {
            n++;
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

            if (userList.resetPassword(username, password)) {
                System.out.println(TEXT_GREEN + "\nAccount for [" + username + "] has been reset successfully." + TEXT_RESET);
                System.out.println("final" + ":" + userList.searchByUsername(username).getUsername() + "," + userList.searchByUsername(username).getPassword());
            }

        } else {

            System.out.println(TEXT_RED + "\nError: [" + username + "] user not found." + TEXT_RESET);

        }
        System.out.print("\n");
    }

}
