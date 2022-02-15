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
    
    public void registration() {
        int n = 0;

        System.out.println("         Registration         ");
        System.out.println("------------------------------");
        System.out.print("Username         : ");
        String username = input.nextLine();
        while ("".equals(username)) {
            System.out.println(TEXT_RED+"Error: Username cannot be empty.\n"+TEXT_RESET);
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
            System.out.println(TEXT_RED+"\nError: [" + username + "] registered before."+TEXT_RESET);
        } else {
            String password;
            String confirmpassword;
            do{
                System.out.print("Password         : ");
                password = input.nextLine();
                while ("".equals(password)) {
                    System.out.println(TEXT_RED+"Error: Password cannot be empty.\n"+TEXT_RESET);
                    System.out.print("Password         : ");
                    password = input.nextLine();
                }
                System.out.print("Confirm Password : ");
                confirmpassword = input.nextLine();
                if(!(password).equals(confirmpassword)){
                    System.out.println(TEXT_RED+"Error: Confirm password not same with password, pls reenter password again.\n"+TEXT_RESET);
                }
            }while (!(password).equals(confirmpassword));
            User s = new User(username, password);
            if (userList.add(s)) {
                System.out.println(TEXT_GREEN+"\nAccount for [" + username + "] has been registered successfully."+TEXT_RESET);
            }
        }
        System.out.print("\n");
    }
    
    public void displayList() {
        if (userList.isEmpty()) {
            System.out.println(TEXT_GREEN+"No user registered."+TEXT_RESET);
        } else {
            System.out.println("============================================\n"
                    + "   Username             Password            \n"
                    + "============================================");
            for (int i = 1; i <= userList.getNumberOfEntries(); i++) {
                System.out.printf(i + ". " + userList.getEntry(i).toString2() + "\n");
            }
            System.out.println("============================================");
        }
        System.out.print("\n");
    }
    //
}
