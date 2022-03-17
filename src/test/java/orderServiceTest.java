/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.orderMapper;
import entity.Order;
import entity.OrderDetail;
import entity.item;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gan
 */
public class orderServiceTest {

    orderMapper<Order> ordSer = new orderService<Order>();
    orderMapper<Order> clone = new orderService<Order>();
    item Item0001 = new item("TestProduct", "This is a test Product", BigDecimal.valueOf(99.1));
    item Item0002 = new item("TestProduct2", "This is a test Product2", BigDecimal.valueOf(99.2));
    item Item0003 = new item("TestProduct3", "This is a test Product3", BigDecimal.valueOf(99.3));
    item Item0004 = new item("TestProduct4", "This is a test Product4", BigDecimal.valueOf(99.4));
    item Item0005 = new item("TestProduct5", "This is a test Product5", BigDecimal.valueOf(99.5));
    item Item0006 = new item("TestProduct6", "This is a test Product6", BigDecimal.valueOf(99.6));

    public orderServiceTest() {
    }

    @Before
    public void setUp() {

        ArrayList<OrderDetail> orderDetails1 = new ArrayList<>();
        orderDetails1.add(new OrderDetail(Item0001, 5));
        orderDetails1.add(new OrderDetail(Item0002, 6));
        orderDetails1.add(new OrderDetail(Item0003, 7));

        ArrayList<OrderDetail> orderDetails2 = new ArrayList<>();
        orderDetails2.add(new OrderDetail(Item0003, 3));
        orderDetails2.add(new OrderDetail(Item0002, 2));
        orderDetails2.add(new OrderDetail(Item0001, 1));

        Order order1 = new Order(orderDetails1);
        Order order2 = new Order(orderDetails2);

        ordSer.enqueue(order1);
        ordSer.enqueue(order2);

        clone.enqueue(order1);
        clone.enqueue(order2);
    }

    /**
     * Test of enqueue method, of class orderService.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        ArrayList<OrderDetail> orderDetails3 = new ArrayList<>();
        orderDetails3.add(new OrderDetail(Item0003, 8));
        orderDetails3.add(new OrderDetail(Item0002, 9));

        Order expResult = new Order(orderDetails3);

        ordSer.enqueue(expResult);

        assertEquals(expResult, ordSer.getEntry(3));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class orderService.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");

        int before = ordSer.getSize();
        ordSer.dequeue();
        int after = ordSer.getSize();

//        
        assertEquals(before - 1, after);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFront method, of class orderService.
     */
    @Test
    public void testGetFront() {
        System.out.println("getFront");

        Order result = ordSer.getFront();

        assertEquals(ordSer.getEntry(1), result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class orderService.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");

        int expResult = 2;
        int result = ordSer.getSize();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class orderService.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");

        boolean expResult = false;
        boolean result = ordSer.isEmpty();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class orderService.
     */
    @Test
    public void testClear() {
        System.out.println("clear");

        ordSer.clear();
        int expResult = 0;
        int result = ordSer.getSize();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntry method, of class orderService.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int index = 2;

        Object expResult = clone.getEntry(index);
        Object result = ordSer.getEntry(index);

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class orderService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ArrayList<OrderDetail> orderDetails3 = new ArrayList<>();
        orderDetails3.add(new OrderDetail(Item0003, 8));
        orderDetails3.add(new OrderDetail(Item0002, 9));

        Order expResult = new Order(orderDetails3);
        int index = 2;

        ordSer.update(expResult, index);

        assertEquals(expResult, ordSer.getEntry(index));

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
