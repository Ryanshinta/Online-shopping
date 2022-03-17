import entity.Announcement;
import org.junit.Before;
import org.junit.Test;
import service.announcementService;

import static org.junit.Assert.*;

import java.util.Iterator;

/**
 *
 * @author Tay Gee Yong
 */
public class testAnnouncement {

    static announcementService<Announcement> annList = new announcementService<>();
    private Announcement a1;

    @Before
    public void setup() {
        a1 = new Announcement(2222, "test case message", "2022/03/22 16:37:15");
        annList.add(a1);
    }

    @Test
    public void testRemoveAnnouncement() {
        boolean expResult = true;
        boolean result = annList.remove(a1);
        assertEquals(expResult, result);

    }

    @Test
    public void testAddAnnouncement() {

        boolean expResult = true;
        annList.add(a1);
        boolean result = false;

        Iterator iterator = annList.getIterator();
        while (iterator.hasNext()) {
            Announcement ann = (Announcement) iterator.next();
            while (ann.getAnnID().equals(2222)) {
                result = true;
                break;
            }
        }

        assertEquals(expResult, result);

    }

}
