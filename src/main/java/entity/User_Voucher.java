/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.Date;
/**
 *
 * @author Acer
 */
public class User_Voucher {
    private String v_name;
    private String v_expired;
    private String v_desc;

    public User_Voucher(String v_name, String v_expired, String v_desc) {
        this.v_name = v_name;
        this.v_expired = v_expired;
        this.v_desc = v_desc;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_expired() {
        return v_expired;
    }

    public void setV_expired(String v_expired) {
        this.v_expired = v_expired;
    }

    public String getV_desc() {
        return v_desc;
    }

    public void setV_desc(String v_desc) {
        this.v_desc = v_desc;
    }

    @Override
    public String toString() {
        return "Voucher    : " + v_name + "<br>Valid Till : " + v_expired + "<br>Description: " + v_desc;
    }
}
