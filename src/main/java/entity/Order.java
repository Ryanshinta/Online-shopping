/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Gan
 */
public class Order {
    private String orderID;
    private ArrayList<OrderDetail> orderDetail;
    private BigDecimal paymentTotal;
    private static int increment;

    public Order() {
    }

    public Order(ArrayList<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
        generateOrderID();
    }

    public void generateOrderID() {
        ++increment;
        this.orderID = "ORD" + String.format("%04d", increment);
    }
//
//    public BigDecimal calculateTotal() {
//        BigDecimal ttl = null;
//        for (int i = 0; i < this.orderDetail.size(); i++) {
//            ttl = ttl.add(this.orderDetail.get(i).getSubtotal());
//        }
//        return ttl;
//    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ArrayList<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(BigDecimal paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public static int getIncrement() {
        return increment;
    }

    public static void setIncrement(int increment) {
        Order.increment = increment;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderDetail=" + orderDetail + ", paymentTotal=" + paymentTotal + '}';
    }
    

}
