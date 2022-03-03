package entity;

/**
 * @author Tay Gee Yong
 *         Announcement for user
 */
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import service.announcementService;

public class Announcement implements Comparable<Announcement> {
    private Integer annID = 1001;
    private String annContents;
    private String annCreatedDateTime;
    private announcementService<Announcement> annList;

    private String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public Announcement(Integer annID, String annContents, String annCreatedDateTime) {
        this.annID = annID++;
        this.annContents = annContents;
        this.annCreatedDateTime = getCurrentDateTime();
        annList = new announcementService<>();
    }

    public announcementService<Announcement> getAnnList() {
        return annList;
    }

    public void setAnnList(announcementService<Announcement> annList) {
        this.annList = annList;
    }

    public Integer getAnnID() {
        return annID;
    }

    public void setAnnID(int annID) {
        this.annID = annID;
    }

    public String getAnnContents() {
        return annContents;
    }

    public void setAnnContents(String annContents) {
        this.annContents = annContents;
    }

    public String getAnnCreatedDateTime() {
        return annCreatedDateTime;
    }

    public void setAnnCreatedDateTime(String annCreatedDateTime) {
        this.annCreatedDateTime = annCreatedDateTime;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-25s %-40s", annID, annContents, annCreatedDateTime);
    }

    public String toString_user() {
        return String.format("%-20s %-25s", annID, annContents);
    }

    @Override
    public int compareTo(Announcement ann) {
        return getAnnID().compareTo(ann.getAnnID());

    }
}
