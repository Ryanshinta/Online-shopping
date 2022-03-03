
import controller.*;
import entity.item;
import java.math.BigDecimal;
import service.ItemService;
/**
 *
 * @author Gan
 */
public class testOrder {
    
    public static void main(String[] args){
        orderController o = new orderController();
        item Item0001 = new item( "TestProduct1", "This is a test Product1", BigDecimal.valueOf(99.99));
        item Item0002 = new item("TestProduct2", "This is a test Product2", BigDecimal.valueOf(99.92));

        item Item003 = new item( "TestProduct3", "This is a test Product3", BigDecimal.valueOf(42.22));
        ItemService itemSer = new ItemService();
        itemSer.newItem(Item0001);
        itemSer.newItem(Item0002);
        itemSer.newItem(Item003);
        
        o.orderMain();
    }
}
    