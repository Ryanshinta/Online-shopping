package controller;

import entity.item;
import service.ItemService;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import static util.textColor.*;

/**
 * @author Ryan
 */
public class itemController {
    ItemService itemService = new ItemService();


    public void menu() {
        while (true) {
            int selection = 0;
            System.out.println("Menu");
            System.out.println("1.New Item");
            System.out.println("2.Delete Item");
            System.out.println("3.Search Item");
            System.out.println("4.Update Item");
            System.out.println("5.Display all Item");
            System.out.println("0.Exit");
            System.out.println("Please enter to Proceed :  ");
            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1:
                    NewItem();
                    break;
                case 2:
                    DeleteItem();
                    break;
                case 3:
                    SearchItem();
                    break;
                case 4:
                    UpdateItem();
                    break;
                case 5:
                    DisplayAllItem();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(TEXT_RED + "Input wrong option, Program will exit" + TEXT_RESET);

            }
        }
    }

    public void NewItem() throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the Name for item: ");
                String itemName = scanner.nextLine();
                if (StringUtils.isAllBlank(itemName) || StringUtils.isAllEmpty(itemName)) {
                    throw new Exception();
                }
                System.out.println("Enter the Desc for item");
                String itemDesc = scanner.nextLine();
                if (StringUtils.isAllBlank(itemDesc) || StringUtils.isAllEmpty(itemDesc)) {
                    throw new Exception();
                }

                System.out.println("Enter the price for item");
                Double itemPrice = scanner.nextDouble();


                if (itemPrice.equals(null) || itemPrice.equals(" ") || itemPrice <= 0) {
                    throw new InputMismatchException();
                }

                System.out.println("New Item Name :" + itemName);
                System.out.println("New Item Desc :" + itemDesc);
                System.out.println("New Item Price :" + itemPrice);
                System.out.println("Process to create new item?(Yes = y, No = n)");
                scanner.nextLine();
                String i = scanner.nextLine();
                if (i.equals("y") || i.equals("Y")) {
                    itemService.newItem(new item(itemName, itemDesc, BigDecimal.valueOf(Double.valueOf(itemPrice))));
                    System.out.println(TEXT_GREEN + "Item add success" + TEXT_RESET);
                    break;
                } else if (i.equals('n') || i.equals("N")) {
                    System.out.println("discard.");
                    break;
                }


                break;
            } catch (InputMismatchException i){
                System.out.println(TEXT_RED + i + TEXT_RESET);
                scanner.nextLine();
                System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
            } catch (Exception e) {
                System.out.println(TEXT_RED + e + TEXT_RESET);
                System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
            }
        }


    }


    public void DeleteItem() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your ID that you want to delete");
            String target = scanner.nextLine();
            item i = itemService.searchById(Integer.valueOf(target));
            if (i == null) {
                System.out.println("No item found");
            } else {
                System.out.println(
                        "Item ID :" + i.getItemID() + "\n" +
                                "Item Name: " + i.getItemName() + "\n" +
                                "Item Desc: " + i.getItemDesc() + "\n" +
                                "Item Price: RM" + i.getItemPrice() + "\n");
                System.out.println("conform delete? (Yea = y, No = n)");
                String n = scanner.nextLine();
                if (n.equals("y") || n.equals("Y")) {
                    itemService.deleteById(Integer.valueOf(target));
                    System.out.println(TEXT_GREEN + "Item delete success" + TEXT_RESET);
                } else if (n.equals('n') || n.equals("N")) {
                    System.out.println("discard.");
                }
            }

        } catch (Exception e) {
            System.out.println(TEXT_RED + e + TEXT_RESET);
            System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
        }

    }

    public void SearchItem() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your ID that you want to search");
            String target = scanner.nextLine();
            item i = itemService.searchById(Integer.valueOf(target));
            if (i == null) {
                System.out.println("No item found");
            } else {
                System.out.println(
                        "Item ID :" + i.getItemID() + "\n" +
                                "Item Name: " + i.getItemName() + "\n" +
                                "Item Desc: " + i.getItemDesc() + "\n" +
                                "Item Price: RM" + i.getItemPrice() + "\n");
            }

        } catch (Exception e) {
            System.out.println(TEXT_RED + e + TEXT_RESET);
            System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
        }
    }

    public void UpdateItem() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your ID that you want to Update");
            String target = scanner.nextLine();
            item i = itemService.searchById(Integer.valueOf(target));
            if (i == null) {
                System.out.println("No item found");
            } else {
                System.out.println(
                        "0. Item ID :" + i.getItemID() + "\n" +
                                "1. Item Name: " + i.getItemName() + "\n" +
                                "2. Item Desc: " + i.getItemDesc() + "\n" +
                                "3. Item Price: RM" + i.getItemPrice() + "\n");
                System.out.println("Which one need modify(ID cannot modify)");
                String n = scanner.nextLine();
                switch (Integer.valueOf(n)) {
                    case 1:
                        System.out.println("Enter the Name for item: ");
                        String itemName = scanner.nextLine();
                        if (StringUtils.isAllBlank(itemName) || StringUtils.isAllEmpty(itemName)) {
                            throw new Exception();
                        }
                        i.setItemName(itemName);
                        System.out.println(TEXT_GREEN+"Update success"+TEXT_RESET);
                        break;
                    case 2:
                        System.out.println("Enter the Desc for item");
                        String itemDesc = scanner.nextLine();
                        if (StringUtils.isAllBlank(itemDesc) || StringUtils.isAllEmpty(itemDesc)) {
                            throw new Exception();
                        }
                        i.setItemDesc(itemDesc);
                        System.out.println(TEXT_GREEN+"Update success"+TEXT_RESET);
                        break;
                    case 3:
                        System.out.println("Enter the price for item");
                        Double itemPrice = scanner.nextDouble();
                        if (itemPrice.equals(null) || itemPrice.equals(" ")) {
                            throw new Exception();
                        }
                        i.setItemPrice(BigDecimal.valueOf(Double.valueOf(itemPrice)));
                        System.out.println(TEXT_GREEN+"Update success"+TEXT_RESET);
                        break;

                    default:
                        System.out.println(
                                "0. Item ID :" + i.getItemID() + "\n" +
                                        "1. Item Name: " + i.getItemName() + "\n" +
                                        "2. Item Desc: " + i.getItemDesc() + "\n" +
                                        "3. Item Price: RM" + i.getItemPrice() + "\n");
                        break;
                }

            }

        } catch (Exception e) {
            System.out.println(TEXT_RED + e + TEXT_RESET);
            System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
        }
    }

    public void DisplayAllItem() {
        System.out.println(TEXT_BLUE + "\n                Wish List                " + TEXT_RESET);
        System.out.println(
                "====================================================================\n"
                        + "ID       Product Name           Desc                       Price   \n"
                        + "====================================================================");
        for (item i : itemService.displayAllItem().values()) {
            System.out.printf("%-8d %-15s        %-25s  RM %.2f \n",
                    i.getItemID(),i.getItemName(),i.getItemDesc(),i.getItemPrice());
        }
    }


}
