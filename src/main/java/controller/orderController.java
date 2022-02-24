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

    public void orderMain() {
        int selection = 0;
        do {
            System.out.println("-------------------------------");
            System.out.println("-         Order Module        -");
            System.out.println("-------------------------------");
            System.out.println("-           1.Add Item         -");
            System.out.println("-           2.Display Cart    -");
            System.out.println("-           3.End             -");
            System.out.println("-------------------------------");
            System.out.println("Please enter to Proceed (exp : 1):  ");
            selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1) {
                addToCart();
            } else if (selection == 2) {
                displayCart();
            }
        } while (selection != 3);

    }

    public void addToCart() {
        int counter = 0;
        boolean ya = true;
        int i = 1;
        int selection = 0;
        int selection2 = 0;

        item Item0001 = new item( "TestProduct1", "This is a test Product1", BigDecimal.valueOf(99.99));
        item Item0002 = new item("TestProduct2", "This is a test Product2", BigDecimal.valueOf(99.92));

        item Item003 = new item( "TestProduct3", "This is a test Product3", BigDecimal.valueOf(42.22));

        ItemService itemSer = new ItemService();
        itemSer.newItem(Item0001);
        itemSer.newItem(Item0002);
        itemSer.newItem(Item003);

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
        System.out.println("");

        tempOrder.add(new OrderDetail(itemSer.searchById(selection), selection2));
        System.out.println("Successfully added to your cart!");

        System.out.println("Going back to main menu....\n");

    }

    public void displayCart() {
        String selection = "";
        BigDecimal total = BigDecimal.valueOf(0);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("|                                    Shopping Cart                                      |");
        System.out.println("|---------------------------------------------------------------------------------------|");
        System.out.println("| Item ID | Item Name    |     Description          | Price/unit | Quantity | Subtotal  |");
        System.out.println("|---------------------------------------------------------------------------------------|");

        for (int j = 0; j < tempOrder.size(); j++) {
            System.out.println("| " + tempOrder.get(j).toString());
            total = total.add(tempOrder.get(j).getSubtotal());
        }
        System.out.println("|---------------------------------------------------------------------------------------|");
        System.out.println("                                                                            |  " + total + "  |");

        System.out.println("Proceed to payment ? (y/n) :");
        scanner.nextLine();

    }
}
