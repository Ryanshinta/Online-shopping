package util;


import dao.userMapper;
import entity.User;
import entity.item;
import service.ItemService;
import service.UserService;

import java.math.BigDecimal;

public class DemoData {
    public void AddDemoData(){
        ItemService itemService = new ItemService();
        item Item0001 = new item("TestProduct","This is a test Product", BigDecimal.valueOf(99.1));
        item Item0002 = new item("TestProduct2","This is a test Product2", BigDecimal.valueOf(99.2));
        item Item0003 = new item("TestProduct3","This is a test Product3", BigDecimal.valueOf(99.3));
        item Item0004 = new item("TestProduct4","This is a test Product4", BigDecimal.valueOf(99.4));
        item Item0005 = new item("TestProduct5","This is a test Product5", BigDecimal.valueOf(99.5));
        item Item0006 = new item("TestProduct6","This is a test Product6", BigDecimal.valueOf(99.6));

        itemService.newItem(Item0001);
        itemService.newItem(Item0002);
        itemService.newItem(Item0003);
        itemService.newItem(Item0004);
        itemService.newItem(Item0005);
        itemService.newItem(Item0006);

        userMapper userList = new UserService();

        userList.newUser(new User("abc", "123"));
        userList.newUser(new User("def", "456"));
        userList.newUser(new User("ghi", "789"));
        userList.newUser(new User("jkl", "012"));
    }
}
