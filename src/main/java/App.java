import java.util.Scanner;

import controller.announcementController;
import controller.itemController;
import controller.orderController;
import controller.userController;
import util.DemoData;

import static controller.userController.CurrentUser;
import static util.textColor.*;

public class App {
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        announcementController announcementController = new announcementController();
        itemController itemController = new itemController();
        userController userController = new userController();
        orderController orderController = new orderController();
        DemoData demoData = new DemoData();
        demoData.AddDemoData();

        // sds
        while (true) {
            int selection = 0;
            String Logo = """
                                                                     \s
                    ,--.   ,--.        ,---.  ,--.                   \s
                    |  |   |  | ,---. '   .-' |  ,---.  ,---.  ,---. \s
                    |  |.'.|  || .-. :`.  `-. |  .-.  || .-. || .-. |\s
                    |   ,'.   |\\   --..-'    ||  | |  |' '-' '| '-' '\s
                    '--'   '--' `----'`-----' `--' `--' `---' |  |-' \s
                                                              `--'   \s
                    """;
            System.out.printf(TEXT_CYAN + Logo + TEXT_RESET);
            System.out.println(TEXT_YELLOW + "Welcome WeShop!" + TEXT_RESET);
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|          Menu          |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|    1. Announcement     |");
            System.out.println("|    2. User Login       |");
            System.out.println("|    3. Item Manage      |");
            System.out.println("|    4. Exit             |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.print("Please enter option to proceed: ");
            System.out.println("Please enter to Proceed :  ");
            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    announcementController.menuAnn();
                    break;
                case 2:
                    userController.userMenu();
                    break;
                case 3:
                    itemController.menu();
                    break;
                case 4:
                    orderController.orderMain();
                    break;
                default:
                    System.out.println(TEXT_RED + "Error: Option Not Found, Please Try Again." + TEXT_RESET);
            }
        }

    }

}
