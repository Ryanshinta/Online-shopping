import static util.textColor.*;
import java.util.Scanner;
import controller.UserController;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. reset password");
        int choice = sc.nextInt();

        if (choice == 1) {
            UserController user = new UserController();
            user.resetPassword();

        }
        System.out.println(TEXT_RED + "This test is red!" + TEXT_RESET);
    }
}
