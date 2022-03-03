package entity;

/**
 * @author Tay Gee Yong
 *         Announcement for user
 */

public class Announcement {
    private static Integer AutoIncrease = 0;
    private Integer annID = 0;
    private String annContents;

    public Announcement(Integer annID, String annContents) {
        AutoIncrease++;
        annID = AutoIncrease;
        this.annContents = annContents;
    }

    public Integer getannID() {
        return annID;
    }

    public String getAnnContents() {
        return annContents;
    }

    public void setAnnContents(String annContents) {
        this.annContents = annContents;
    }

    @Override
    public String toString() {
        return "Announcements" +
                "annID='" + annID + '\'' +
                ", annContents='" + annContents;
    }
}
