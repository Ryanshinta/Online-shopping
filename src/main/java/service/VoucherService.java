/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Voucher;
import dao.voucherMapper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class VoucherService implements voucherMapper {
    private static ArrayList<Voucher> VoucherArray = new ArrayList<Voucher>();

    @Override
    public boolean newVoucher(Voucher v) {
        if(VoucherArray.add(v)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVoucher(Voucher v) {
        if(VoucherArray.remove(v)) {
            return true;
        }
        return false;
    }

    @Override
    public String displayAllVoucher() {
        String str = "";
        if(VoucherArray.isEmpty()) {
            return null;
        }
        for(int i = 0; i < VoucherArray.size(); i++) {
            str += String.format("%02d. %-20s %-20s %-20s\n", i + 1, VoucherArray.get(i).getName(), VoucherArray.get(i).getExpired(), VoucherArray.get(i).getDesc());
        }
        return str;
    }

    @Override
    public void validVoucher(Date date) {
        for(Voucher voucher:VoucherArray) {
            String vdate = voucher.getExpired();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         
            Date validDate;
            String s;
             
            try {
                validDate = dateFormat.parse(vdate);  
                if(validDate.before(date)) {
                    s = "h";
                }
            } catch (ParseException e) {
                
            }
            System.out.print("s");
        }
    }
}
