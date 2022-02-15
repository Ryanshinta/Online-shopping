
import entity.item;
import service.ItemService;

import java.math.BigDecimal;

import static util.textColor.TEXT_RED;
import static util.textColor.TEXT_RESET;

public class testItemCRUD {
    public static void main(String[] args){
        ItemService itemService = new ItemService();
        item Item0001 = new item(0001,"TestProduct","This is a test Product", BigDecimal.valueOf(99.99));
        item Item0002 = new item(0002,"TestProduct2","This is a test Product2", BigDecimal.valueOf(99.92));
        // new item
        itemService.newItem(Item0001);
        itemService.newItem(Item0002);
        // search itme
        item searchItem1 = itemService.searchById(0001);
        item searchItem2 = itemService.searchById(0002);
        System.out.println(searchItem1.toString()+"\n"+searchItem2.toString());
        // update item
        Item0002.setItemPrice(BigDecimal.valueOf(22.22));
        itemService.updateItemById(Item0002.getItemID(),Item0002);
        item searchItem3 = itemService.searchById(0002);
        System.out.println(searchItem3.toString());
        // delete item
        itemService.deleteById(0002L);
        item deleteItem = itemService.searchById(0002);
        if (deleteItem == null){
            System.out.println(TEXT_RED+"ID 0002 already deleted"+TEXT_RESET);
        }else {
            System.out.println(deleteItem.toString());
        }

    }
}
