package entity;

public class Voucher {
    private String name;
    private String expired;
    private String desc;

    public Voucher(String name, String expired, String desc) {
        this.name = name;
        this.expired = expired;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "Voucher    : " + name + "<br>Expired    : " + expired + "<br>Description: " + desc;
    }

}
