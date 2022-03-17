package entity;

public class Voucher {
    private String name;
    private String expired;
    private String desc;
    private int deducOrder;
    private int deducDelivery;

    public Voucher(String name, String expired, String desc, int deducOrder, int deducDelivery) {
        this.name = name;
        this.expired = expired;
        this.desc = desc;
        this.deducOrder = deducOrder;
        this.deducDelivery = deducDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
    
    public String getDesc() {
        return desc;
    }

    public void Desc(String desc) {
        this.desc = desc;
    }

    public int getDeducOrder() {
        return deducOrder;
    }

    public void setDeducOrder(int deducOrder) {
        this.deducOrder = deducOrder;
    }

    public int getDeducDelivery() {
        return deducDelivery;
    }

    public void setDeducDelivery(int deducDelivery) {
        this.deducDelivery = deducDelivery;
    }

    
    
    @Override
    public String toString() {
        return "Voucher    : " + name + "<br>Expired    : " + expired + "<br>Description: " + desc;
    }

}
