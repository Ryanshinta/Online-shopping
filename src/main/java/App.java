import java.util.Scanner;
import controller.userController;
import controller.announcementController;
import controller.orderController;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // userController user = new userController();
        // user.reset();

        announcementController ann = new announcementController();
        ann.hardCode();

    }
}
