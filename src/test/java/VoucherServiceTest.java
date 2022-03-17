import entity.Voucher;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.VoucherService;

/**
 *
 * @author Acer
 */
public class VoucherServiceTest {
    VoucherService voucherService = new VoucherService();
    private Voucher v1, v2, v3;
    
    public VoucherServiceTest() {
    }
    
    @Before
    public void setUp() {
        v1 = new Voucher("RM5 off", "31.01.2022", "Enjoy RM5 off on your order.", 5, 0);
        v2 = new Voucher("RM10 off", "20.03.2022", "Enjoy RM10 off on your order.", 10, 0);
        v3 = new Voucher("Free shipping", "31.03.2022", "Enjoy RM4 off on shipping fee.", 0, 4);
        voucherService.newVoucher(v1);
        voucherService.newVoucher(v2);
        voucherService.newVoucher(v3);
    }

    @Test
    public void testNewVoucher() {
        System.out.println("newVoucher");
        Voucher v = new Voucher("RM15 off", "31.12.2022", "Enjoy RM15 off on your order.", 15, 0);
        VoucherService instance = new VoucherService();
        boolean expResult = true;
        boolean result = instance.newVoucher(v);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteVoucher() {
        System.out.println("deleteVoucher");
        Voucher v = v2;
        VoucherService instance = new VoucherService();
        boolean expResult = true;
        boolean result = instance.deleteVoucher(v);
        assertEquals(expResult, result);
    }
    
}
