/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import service.UserService;

/**
 *
 * @author Acer
 */
public class testLogin {
    UserService userService = new UserService();
    private User u1, u2, u3;
    
    public testLogin() {
    }
    
    @Before
    public void setUp() {
        u1 = new User("abc", "123");
        u2 = new User("def", "456");
        u3 = new User("ghi", "789");
        userService.newUser(u1);
        userService.newUser(u2);
        userService.newUser(u3);
    }
    
    @Test
    public void testContainUser() {
        System.out.println("containUser");
        //User u = new User("abc", "123");
        User u = new User("abc", "124");
        UserService instance = new UserService();
        boolean expResult = true;
        boolean result = instance.containUser(u);
        assertEquals(expResult, result);
    }
    
}
