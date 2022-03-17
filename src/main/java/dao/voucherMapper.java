/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Voucher;
import java.util.Date;

/**
 *
 * @author YoonEn
 */
public interface voucherMapper {

    boolean newVoucher(Voucher v);

    boolean deleteVoucher(Voucher v);
    
    Voucher validVoucher(Date date);

    String displayAllVoucher();
    
    int totalEntry();
    
    Voucher getEntry(int index);

    


}
