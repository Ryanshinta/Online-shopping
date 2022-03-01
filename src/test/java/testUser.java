/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.userController;
import entity.item;
import service.ItemService;

import java.math.BigDecimal;

/**
 *
 * @author Acer
 */
public class testUser {
    
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        item Item0001 = new item("TestProduct","This is a test Product", BigDecimal.valueOf(99.91));
        item Item0002 = new item("TestProduct2","This is a test Product2", BigDecimal.valueOf(99.92));
        item Item0003 = new item("TestProduct3","This is a test Product3", BigDecimal.valueOf(99.93));
        item Item0004 = new item("TestProduct4","This is a test Product4", BigDecimal.valueOf(99.94));
        item Item0005 = new item("TestProduct5","This is a test Product5", BigDecimal.valueOf(99.95));
        item Item0006 = new item("TestProduct6","This is a test Product6", BigDecimal.valueOf(99.96));
        // new item
        itemService.newItem(Item0001);
        itemService.newItem(Item0002);
        itemService.newItem(Item0003);
        itemService.newItem(Item0004);
        itemService.newItem(Item0005);
        itemService.newItem(Item0006);
        
        userController c = new userController();
        c.userMenu();
    }
    
}
