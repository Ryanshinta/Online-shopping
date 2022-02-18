/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;

/**
 *
 * @author Gan
 */
public class OrderDetail {
    private item item;
    private int quantity;
    private BigDecimal subtotal;
    
    public OrderDetail() {
    }
    
    public OrderDetail(item Item, int quantity) {
        this.item = Item;
        this.quantity = quantity;
        this.subtotal = calculateSubtotal();
    }
    
    public BigDecimal calculateSubtotal(){
        BigDecimal result = new BigDecimal(quantity).multiply(item.getItemPrice());

        return result;
    }

    public item getItem() {
        return item;
    }

    public void setItem(item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    public String toString(){
        return "   "+ item.getItemID() +"    | "+ item.getItemName() + " |  " + item.getItemDesc() + " |   " + item.getItemPrice()  + "    |    " + quantity + "     |   " + subtotal + "  |";
    }
}
