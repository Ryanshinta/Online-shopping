import java.util.Scanner;

import controller.announcementController;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        announcementController ann = new announcementController();
        ann.menuAnn();

    }
}
