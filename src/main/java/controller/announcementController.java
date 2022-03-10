package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import entity.Announcement;
import service.announcementService;
import static util.textColor.TEXT_GREEN;
import static util.textColor.TEXT_RED;
import static util.textColor.TEXT_RESET;

public class announcementController {
    private Scanner input = new Scanner(System.in);
    static announcementService<Announcement> annList = new announcementService<>();

    public void characterInput() {
        while (!input.hasNextInt()) {
            System.out.println(TEXT_RED + "Error: Can only accept integer.\n" + TEXT_RESET);
            System.out.print("Please enter option to proceed: ");
            input.next();
        }
    }

    public void checkInputAnnContent(){
       
    }

    public void menuAnn() {
        // hardCode();
        int selection = 0;
        while (selection != 5) {
            System.out.println("\n|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|        Menu        |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|    1. Create       |");
            System.out.println("|    2. Update       |");
            System.out.println("|    3. Delete       |");
            System.out.println("|    4. Display All  |");
            System.out.println("|    5. Exit         |");
            System.out.println("|~~~~~~~~~~~~~~~~~~~~|");
            System.out.print("Please enter option to proceed: ");
            characterInput();
            selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    createAnn();
                    break;
                case 2:
                    updateAnn();
                    break;
                case 3:
                    deleteAnn();
                    break;
                case 4:
                    displayAnn();
                    break;
                case 5:
                    break;
                default:
                    System.out.println(TEXT_RED + "Error: Option Not Found, Please Try Again." + TEXT_RESET);

            }
        }
    }

    public void createAnn() {
        // ** get total size of set */
        int temp = annList.size() + 1;

        // ** add the total size of set with 1000 as annID */
        int annID = 1000 + temp;
        String annContents;
        String annCreatedDateTime = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        boolean checkDuplicate = true;

        do {

            if (annList.isEmpty()) {
                System.out.println(TEXT_RED+"No announcement in list\n"+TEXT_RESET);

                hardCode();
                System.out.println(TEXT_GREEN + "Added default announcement succesfully\n"+TEXT_RESET);
                
            }

            System.out.print("\nEnter announcement: ");
            annContents = input.nextLine();
            while (annContents.equals("") || annContents.equals(" ")) {
                System.out.println(TEXT_RED + "Error: Input cannot be empty\n" + TEXT_RESET);
                System.out.print("Please enter again: ");
                annContents = input.nextLine();
            }
            // ** create a iterator to do searching */
            Iterator iterator = annList.getIterator();

            // ** enter the looping when there is elements in iterator */
            while (iterator.hasNext()) {
                // ** get the next element in the iterator */
                Announcement annElement = (Announcement) iterator.next();

                // **add in the new hobby if there is no duplicate hobby name */
                if (!(annElement.getAnnContents().equals(annContents))) {
                    System.out.println(TEXT_GREEN+"New Announcement added\n" + TEXT_RESET);
                    annList.add(new Announcement(annID, annContents, annCreatedDateTime));
                    checkDuplicate = false;
                    break;
                } else {
                    System.out.println("Duplicate Announcement, enter again");
                    break;
                }
            }
        } while (checkDuplicate);

        pressAnyKeyToContinue();

    }

    public void updateAnn() {

    }

    public void deleteAnn() {

    }

    public void displayAnn() {

        System.out.println("\nAnnouncement List");

        if (!annList.isEmpty()) {

            System.out.println(annList.toString());

        } else {
            System.out.println(TEXT_RED+"No announcement in list\n"+TEXT_RESET);

            hardCode();
            System.out.println(TEXT_GREEN+"Added default announcement succesfully\n"+TEXT_RESET);
        }
        pressAnyKeyToContinue();
    }

    private static void pressAnyKeyToContinue() {
        System.out.println("\nPress Any key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public void hardCode() {
        annList.add(new Announcement(1000, "New item coming out", "03/03/2022 17:54:50"));

    }
    
}