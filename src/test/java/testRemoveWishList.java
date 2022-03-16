import entity.User;
import entity.item;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.Test;
import service.ItemService;
import service.UserService;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.*;

public class testRemoveWishList {
    UserService userService = new UserService();
    ItemService itemService = new ItemService();
    private User u1,u2,userTest;
    private item i1,i2;

    @Before
    public void setup(){

        u1 = new User("QQQ","123");
        i1 = new item("Test91","TestItem", BigDecimal.valueOf(12.1));
        userService.newUser(u1);
        itemService.newItem(i1);
        userTest = userService.searchByUsername("QQQ");
        userTest.getWishList().add(i1);
    }



    @Test
    public void testRemoveFromWishList(){
        assertTrue(userTest.getWishList().remove(0) != null);


    }

}
