package entity;

import java.math.BigDecimal;

/**
 * @author Ryan Ouyang
 * Basic entity for item
 */
public class item {
    private static Integer AutoIncrease = 0;
    private Integer itemID = 0;
    private String itemName;
    private String itemDesc;
    private BigDecimal itemPrice;

    public item(String itemName, String itemDesc, BigDecimal itemPrice) {
        AutoIncrease++;
        itemID = AutoIncrease;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
    }

    public Integer getItemID() {
        return itemID;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "item" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemPrice=" + itemPrice ;
    }
}
