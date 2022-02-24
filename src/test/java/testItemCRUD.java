
import controller.itemController;
import entity.item;
import service.ItemService;

import java.math.BigDecimal;

import static util.textColor.TEXT_RED;
import static util.textColor.TEXT_RESET;

public class testItemCRUD {
    public static void main(String[] args){

        ItemService itemService = new ItemService();
        item Item0001 = new item("TestProduct","This is a test Product", BigDecimal.valueOf(99.99));
        item Item0002 = new item("TestProduct2","This is a test Product2", BigDecimal.valueOf(99.92));
        item Item0003 = new item("TestProduct3","This is a test Product3", BigDecimal.valueOf(99.92));
        item Item0004 = new item("TestProduct4","This is a test Product4", BigDecimal.valueOf(99.92));
        item Item0005 = new item("TestProduct5","This is a test Product5", BigDecimal.valueOf(99.92));
        item Item0006 = new item("TestProduct6","This is a test Product6", BigDecimal.valueOf(99.92));
        // new item
        itemService.newItem(Item0001);
        itemService.newItem(Item0002);
        itemService.newItem(Item0003);
        itemService.newItem(Item0004);
        itemService.newItem(Item0005);
        itemService.newItem(Item0006);
        //Display All item
/*
        for (item i:itemService.displayAllItem().values()) {
            System.out.println(i.getItemID());
        }

*/






//
//        // search item
//        item searchItem1 = itemService.searchById(1);
//        item searchItem2 = itemService.searchById(2);
//        try {
//            System.out.println(searchItem1.toString()+"\n"+searchItem2.toString());
//        }catch (NullPointerException e){
//            System.out.println(e);
//        }
//
//        // update item
//        Item0002.setItemPrice(BigDecimal.valueOf(22.22));
//
//        item searchItem3 = itemService.searchById(0002);
//        System.out.println(searchItem3.toString());
//        // delete item
//        item deleteItem = itemService.searchById(0002);
//        if (deleteItem == null){
//            System.out.println(TEXT_RED+"ID 0002 already deleted"+TEXT_RESET);
//        }else {
//            System.out.println(deleteItem.toString());
//        }

        itemController itemController = new itemController();
        itemController.menu();


    }



}
