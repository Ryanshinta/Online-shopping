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
                String itemPrice = scanner.nextLine();
                if (StringUtils.isNumeric(itemPrice) || StringUtils.isAllEmpty(itemPrice) || StringUtils.isBlank(itemPrice)) {
                    throw new Exception();
                }

                System.out.println("New Item Name :" + itemName);
                System.out.println("New Item Desc :" + itemDesc);
                System.out.println("New Item Price :" + itemPrice);
                System.out.println("Process to create new item?(Yes = y, No = n)");
                String i = scanner.nextLine();
                if (i.equals("y") || i.equals("Y")) {
                    itemService.newItem(new item(itemName, itemDesc, BigDecimal.valueOf(Double.valueOf(itemPrice))));
                    System.out.println(TEXT_GREEN + "Item add success" + TEXT_RESET);
                    break;
                } else if (i.equals('n')|| i.equals("N")) {
                    System.out.println("discard.");
                    break;
                }


                break;
            } catch (Exception e) {
                System.out.println(TEXT_RED + e + TEXT_RESET);
                System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
            }
        }


    }


    public void DeleteItem() {

    }

    public void SearchItem() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your ID that you want to search");
            String target = scanner.nextLine();

        }catch (Exception e){
            System.out.println(TEXT_RED + e + TEXT_RESET);
            System.out.println(TEXT_RED + "invalid input Please enter again." + TEXT_RESET);
        }
    }

    public void UpdateItem() {

    }

    public void DisplayAllItem() {
        for (item i:itemService.displayAllItem().values()) {
            System.out.println(i.getItemID()+ "\n" +
                    i.getItemName()+"\n"+
                    i.getItemDesc()+"\n"+
                    i.getItemPrice());
        }
    }


}
