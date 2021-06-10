import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ContactsManager {

    public static String[] menuOptions = {
        "View contacts.",
        "Add a new contact.",
        "Search a contact by name.",
        "Delete an existing contact.",
        "Exit."
    };

    public static Input input = new Input();

    public static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        for (int i = 0; i < menuOptions.length; ++i) {
            System.out.println(i + 1 + ". " + menuOptions[i]);
        }

        // This uses getInt to grab a number from 1 to the total length of menu options
        int userNum = input.getInt(1, menuOptions.length);
        String userChoice = menuOptions[userNum - 1];

        System.out.println(userChoice);

    }


    public static void createContact() {
       String userContactName = input.getString();
       int userContactNum = input.getIntStr();

    }


    public static void main(String[] args) {
        displayMenu();
//        Path contactsFolder = Paths.get("src/contacts");

//        Path contactsFile = Paths.get(String.valueOf(contactsFolder),"contacts.txt");

    }
}

//        //        Create directory
//        try {
//            if (Files.notExists(toOurDataPlace)) {
//                Files.createDirectories(toOurDataPlace);
//            }else {
//                System.out.println("The " + toOurDataPlace + " directory already exists.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        Create file
//        try {
//            if (Files.notExists(toOurDataFile)) {
//                Files.createFile(toOurDataFile);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }