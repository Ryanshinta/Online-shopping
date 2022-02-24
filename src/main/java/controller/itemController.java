package controller;

import entity.item;
import service.ItemService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static util.textColor.TEXT_RED;
import static util.textColor.TEXT_RESET;

/**
 * @author Ryan
 */
public class itemController {
    ItemService itemService;
    item Item0001 = new item("TestProduct","This is a test Product", BigDecimal.valueOf(99.99));
    item Item0002 = new item("TestProduct2","This is a test Product2", BigDecimal.valueOf(99.92));

    public void menu(){
        int selection = 0;
        System.out.println("Menu");
        System.out.println("1.New Item");
        System.out.println("2.Delete Item");
        System.out.println("3.Search Item");
        System.out.println("4.Update Item");
        System.out.println("5.Display all Item");
        System.out.println("Please enter to Proceed (exp : 1):  ");
        Scanner scanner = new Scanner(System.in);
        selection = scanner.nextInt();
        scanner.nextLine();
        switch (selection){
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
            default:

        }
    }

    public void NewItem(){
        Scanner scanner = new Scanner(System.in);
        boolean error = false;
        if(error == false){
            System.out.println("Enter the ID for item");
            try {
                Integer itemCode = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println(TEXT_RED+e+TEXT_RESET);

            }

            System.out.println("Enter the Name for item");
            String itemName = scanner.nextLine();
            System.out.println("Enter the Desc for item");
            String itemDesc = scanner.nextLine();

            System.out.println("Enter the ");

            itemService.newItem(Item0001);
            itemService.newItem(Item0002);
            System.out.println("Item add success");
        }


    }
    public void DeleteItem(){

    }
    public void SearchItem(){
        item searchItem1 = itemService.searchById(0001);
        item searchItem2 = itemService.searchById(0002);
        System.out.println(searchItem1.toString()+"\n"+searchItem2.toString());
    }
    public void UpdateItem(){

    }
    public void DisplayAllItem(){
        System.out.println(itemService.displayAllItem().toString());
    }




}
