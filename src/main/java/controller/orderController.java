/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.voucherMapper;
import entity.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import service.*;
import static util.textColor.*;

/**
 *
 * @author Gan
 */
public class orderController {
    
    Scanner scanner = new Scanner(System.in);
    static ArrayList<OrderDetail> tempOrder = new ArrayList<>();

    ItemService itemSer = new ItemService();
    announcementService<Announcement> annList = new announcementService<>();
    
    private voucherMapper voucherList = new VoucherService();

    public void orderMain() {
        int selection = 0;
        boolean buffer = true;
        hardCodeVoucher();
        validVoucher();

        do {
            System.out.println("-------------------------------");
            System.out.println("-         Shopping Cart        -");
            System.out.println("-------------------------------");
            System.out.println("-         1.Add Item          -");
            System.out.println("-         2.Remove Item       -");
            System.out.println("-         3.Update Item       -");
            System.out.println("-         4.Display Cart      -");
            System.out.println("-         5.Make Payment      -");
            System.out.println("-         6.Voucher           -");
            System.out.println("-         7.End               -");
            System.out.println("-------------------------------");

            try {
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
                    updateFromCart();
                    returnMenu();
                } else if (selection == 4) {
                    displayCart();
                    returnMenu();
                }else if (selection == 5) {
                    makePayment();
                    returnMenu();
                }else if (selection == 6) {
                    viewVoucher();
                    returnMenu();
                } else if (selection != 7) {
                    System.out.println(TEXT_RED + "Invalid input !!!\n" + TEXT_RESET);
                }
            } catch (Exception e) {
                System.out.println(TEXT_RED + "\nOnly enter integer !!!!\n" + TEXT_RESET);
                selection = 8;
                scanner.nextLine();

            }
        } while (selection != 7);

    }

    public void addToCart() {
        int counter = 0;
        boolean ya = true;
        int i = 1;
        int selection = 0;
        int selection2 = 0;

        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.println(
                "-                                          Products                                                -");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        while (ya != false) {
            item tempItem = itemSer.searchById(i);

            if (tempItem != null) {
                System.out.println("| " + i + ". " + tempItem + "  |");
                i++;
            } else {
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
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

        if (tempOrder.isEmpty()) {
            System.out.println("\nThe shopping cart is empty.......\n");
        } else {
            do {
                System.out.println("Enter the item you want to remove (exp:2)");
                try {
                    selection = scanner.nextInt();
                    scanner.nextLine();
                    if (selection > tempOrder.size() || selection < 1) {
                        buffer = false;
                        System.out.println(TEXT_RED + "\nThe number entered is out of range !!\n" + TEXT_RESET);

                    } else {
                        do {
                            System.out.println("Comfirm remove item no." + selection + " ? (y/n) : ");
                            x = scanner.nextLine();

                            if ("N".equals(x.toUpperCase())) {
                                buffer = true;
                            } else if ("Y".equals(x.toUpperCase())) {
                                tempOrder.remove(selection - 1);
                                System.out.println(TEXT_GREEN + "\nRemove successfully form cart !!" + TEXT_RESET);
                                buffer = true;
                            } else {
                                System.out
                                        .println(TEXT_RED + "\nInvalid input, please enter 'y' or 'n'\n" + TEXT_RESET);
                                buffer = false;
                            }
                        } while (buffer == false);
                    }
                } catch (Exception e) {
                    System.out.println(TEXT_RED + "\nOnly enter integer !!!!\n" + TEXT_RESET);
                    buffer = false;
                    scanner.nextLine();

                }

            } while (buffer == false);
        }
    }

    public void updateFromCart() {
        int selection = 0;
        int selection2 = 0;
        boolean buffer = true;
        String x = null;

        displayCart();

        if (tempOrder.isEmpty()) {
            System.out.println("\nThe shopping cart is empty.......\n");
        } else {
            do {
                buffer = true;
                System.out.println("Enter the item you want to update (-1 to exit)");
                try {
                    selection = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println(TEXT_RED + "\nOnly enter integer !!!!\n" + TEXT_RESET);
                    buffer = false;
                    scanner.nextLine();

                }
                if (buffer != false) {
                    if (selection == -1) {
                        buffer = true;
                    } else if (selection > tempOrder.size() || selection < 1) {
                        buffer = false;
                        System.out.println(TEXT_RED + "\nThe number entered is out of range !!\n" + TEXT_RESET);

                    } else {
                        tempOrder.get(selection - 1);

                        System.out.println("Item No : " + selection);

                        menuHeading();
                        System.out.println("| " + selection + ". | " + tempOrder.get(selection - 1).toString());
                        System.out.println(
                                "|--------------------------------------------------------------------------------------------|");

                        do {
                            System.out.println("\nEnter the new quantity (-1 to exit): ");
                            try {
                                selection2 = scanner.nextInt();
                                scanner.nextLine();

                                if (selection2 == -1) {
                                    buffer = true;
                                } else if (selection2 < 1) {
                                    buffer = false;
                                    System.out.println(
                                            TEXT_RED + "\nThe number entered is out of range !!\n" + TEXT_RESET);

                                } else {
                                    do {
                                        System.out.println("Comfirm update item no." + selection + " ? (y/n) : ");
                                        x = scanner.nextLine();

                                        if ("N".equals(x.toUpperCase())) {
                                            buffer = true;
                                        } else if ("Y".equals(x.toUpperCase())) {
                                            tempOrder.get(selection - 1).setQuantity(selection2);
                                            System.out.println(TEXT_GREEN + "\nUpdate successfully  !!" + TEXT_RESET);
                                            buffer = true;
                                        } else {
                                            System.out.println(TEXT_RED + "\nInvalid input, please enter 'y' or 'n'\n"
                                                    + TEXT_RESET);
                                            buffer = false;
                                        }
                                    } while (buffer == false);
                                }
                            } catch (Exception e) {
                                System.out.println(TEXT_RED + "\nOnly enter integer !!!!\n" + TEXT_RESET);
                                buffer = false;
                                scanner.nextLine();

                            }
                        } while (buffer == false);
                    }
                }
            } while (buffer == false);
        }
    }

    public void makePayment() {

        displayCart();
        
        if (tempOrder.isEmpty()) {
            System.out.println("Cannot proceed to payment method when the sopping cart is empty !!");
        }else{
            
        }
        
    }

    public void displayCart() {
        int counter = 0;
        String selection = "";
        BigDecimal total = BigDecimal.valueOf(0);
        menuHeading();

        if (tempOrder.isEmpty()) {
            System.out.println(
                    "| -  |    -    |     -        |          -               |     -      |    -     |    -      |");
        } else {

            for (int j = 0; j < tempOrder.size(); j++) {
                System.out.println("| " + ++counter + ". | " + tempOrder.get(j).toString());
                total = total.add(tempOrder.get(j).getSubtotal());
            }
        }
        System.out.println(
                "|--------------------------------------------------------------------------------------------|");
        System.out.println(
                "                                                                                 |  " + total + "  |");

    }

    public void returnMenu() {
        System.out.println("*Press enter to return to main menu*");
        scanner.nextLine();
    }

    public void menuHeading() {
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.println(
                "|                                    Shopping Cart                                           |");
        System.out.println(
                "|--------------------------------------------------------------------------------------------|");
        System.out.println(
                "| No | Item ID | Item Name    |     Description          | Price/unit | Quantity | Subtotal  |");
        System.out.println(
                "|--------------------------------------------------------------------------------------------|");
    }
    
    public void hardCodeVoucher() {
        voucherList.newVoucher(new Voucher("RM5 off", "31.01.2022", "Enjoy RM5 off on your order."));
        voucherList.newVoucher(new Voucher("RM10 off", "28.02.2022", "Enjoy RM10 off on your order."));
        voucherList.newVoucher(new Voucher("Free shipping", "15.03.2022", "Enjoy RM4 off on shipping fee."));
        voucherList.newVoucher(new Voucher("Free shipping", "16.03.2022", "Enjoy RM4 off on shipping fee."));
        voucherList.newVoucher(new Voucher("Free shipping", "31.05.2022", "Enjoy RM4 off on shipping fee."));
    }
    
    public void validVoucher() {
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();  
        Date todayDate = new Date();
        try {
            todayDate = format.parse(format.format(today));
        } catch (ParseException e) {
                
        }
        do {
            Voucher v = voucherList.validVoucher(todayDate);
            voucherList.deleteVoucher(v);
        } while (voucherList.validVoucher(todayDate) != null);
    }
    
    public void viewVoucher() {
        if (voucherList.displayAllVoucher() == null) {
            System.out.println(TEXT_BLUE + "No voucher found." + TEXT_RESET);
        } else {
            System.out.println(TEXT_BLUE + "\n                                 Voucher List                                " + TEXT_RESET);
            System.out.println("================================================================================\n"
                    + "    Name                 Valid Till           Description            \n"
                    + "================================================================================");
            System.out.printf(voucherList.displayAllVoucher() + "\n");

            System.out.println("================================================================================");
        }
    }
}
