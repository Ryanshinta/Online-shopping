/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import service.*;

/**
 *
 * @author Gan
 */
public class orderController {

    Scanner scanner = new Scanner(System.in);
    static ArrayList<OrderDetail> tempOrder = new ArrayList<>();

    ItemService itemSer = new ItemService();

    public void orderMain() {
        int selection = 0;
        boolean buffer = true;
        do {
            System.out.println("-------------------------------");
            System.out.println("-         Shopping Cart        -");
            System.out.println("-------------------------------");
            System.out.println("-         1.Add Item          -");
            System.out.println("-         2.Remove Item       -");
            System.out.println("-         3.Display Cart      -");
            System.out.println("-         4.End               -");
            System.out.println("-------------------------------");
            System.out.println("Please enter to Proceed (exp : 1):  ");
            selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1) {
                addToCart();
                returnMenu();
            } else if (selection == 2) {
                removeFromCart();
                returnMenu();
            } else if (selection == 3) {
                displayCart();
                returnMenu();
            } else if (selection != 4) {
                System.out.println("Invalid input !!!\n");
            }

        } while (selection != 4);

    }

    public void addToCart() {
        int counter = 0;
        boolean ya = true;
        int i = 1;
        int selection = 0;
        int selection2 = 0;

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("-                                          Products                                                -");
        System.out.println("----------------------------------------------------------------------------------------------------");

        while (ya != false) {
            item tempItem = itemSer.searchById(i);

            if (tempItem != null) {
                System.out.println("| " + i + ". " + tempItem + "  |");
                i++;
            } else {
                System.out.println("----------------------------------------------------------------------------------------------------");
                ya = false;
            }
        }

        System.out.println("Please enter the item no to put into cart (exp: 2) :  ");
        selection = scanner.nextInt();
        System.out.println("");

        System.out.println("Enter the quantity  :  ");
        selection2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        tempOrder.add(new OrderDetail(itemSer.searchById(selection), selection2));
        System.out.println("Successfully added to your cart!");

    }

    public void removeFromCart() {
        int selection = 0;
        boolean buffer = true;
        String x = null;

        displayCart();

        do {
            System.out.println("Enter the item you want to remove (exp:2)");
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
                if (selection > tempOrder.size() || selection < 1) {
                    buffer = false;
                    System.out.println("\nThe number entered is out of range !!\n");

                } else {
                    do {
                        System.out.println("Comfirm remove item no." + selection + " ? (y/n) : ");
                        x = scanner.nextLine();

                        if ("N".equals(x.toUpperCase())) {
                            buffer = true;
                        } else if ("Y".equals(x.toUpperCase())) {
                            tempOrder.remove(selection - 1);
                            System.out.println("\nRemove successfully form cart !!");
                            buffer = true;
                        } else {
                            System.out.println("\nInvalid input, please enter 'y' or 'n'\n");
                            buffer = false;
                        }
                    } while (buffer == false);
                }
            } catch (Exception e) {
                System.out.println("\nOnly enter digit !!!!\n");
                buffer = false;
                scanner.nextLine();

            }
            
        } while (buffer == false);
    }

    public void displayCart() {
        int counter = 0;
        String selection = "";
        BigDecimal total = BigDecimal.valueOf(0);
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("|                                    Shopping Cart                                           |");
        System.out.println("|--------------------------------------------------------------------------------------------|");
        System.out.println("| No | Item ID | Item Name    |     Description          | Price/unit | Quantity | Subtotal  |");
        System.out.println("|--------------------------------------------------------------------------------------------|");

        for (int j = 0; j < tempOrder.size(); j++) {
            System.out.println("| " + ++counter + ". | " + tempOrder.get(j).toString());
            total = total.add(tempOrder.get(j).getSubtotal());
        }
        System.out.println("|--------------------------------------------------------------------------------------------|");
        System.out.println("                                                                                 |  " + total + "  |");

    }

    public void returnMenu() {
        System.out.println("*Press enter to return to main menu*");
        scanner.nextLine();
    }
}
