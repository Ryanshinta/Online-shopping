import java.util.Scanner;

import controller.announcementController;
import util.DemoData;

public class App {

    public static void main(String[] args) {
        DemoData demoData = new DemoData();
        demoData.AddDemoData();

        Scanner sc = new Scanner(System.in);

        announcementController ann = new announcementController();
        ann.menuAnn();

    }
}
