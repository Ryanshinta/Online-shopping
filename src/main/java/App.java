import java.util.Scanner;

import controller.announcementController;
import util.DemoData;

import static controller.userController.CurrentUser;
import static util.textColor.*;

public class App {

    public static void main(String[] args) {
        DemoData demoData = new DemoData();
        demoData.AddDemoData();
        String Logo= """
                                                                 \s
                ,--.   ,--.        ,---.  ,--.                   \s
                |  |   |  | ,---. '   .-' |  ,---.  ,---.  ,---. \s
                |  |.'.|  || .-. :`.  `-. |  .-.  || .-. || .-. |\s
                |   ,'.   |\\   --..-'    ||  | |  |' '-' '| '-' '\s
                '--'   '--' `----'`-----' `--' `--' `---' |  |-' \s
                                                          `--'   \s
                """;
        System.out.printf(TEXT_CYAN+Logo+TEXT_RESET);

    }
}
