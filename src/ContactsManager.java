import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {

    public static String[] menuOptions = {
        "View contacts.",
        "Add a new contact.",
        "Search a contact by name.",
        "Delete an existing contact.",
        "Exit."
    };

//    public static Input input = new Input();

    public static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        Input in = new Input();
        for (int i = 0; i < menuOptions.length; ++i) {
            System.out.println(i + 1 + ". " + menuOptions[i]);
        }

        // This uses getInt to grab a number from 1 to the total length of menu options
        int userNum = in.getInt(1, menuOptions.length);
        String userChoice = menuOptions[userNum - 1];

        System.out.println(userChoice);

    }

    public static void createPath() {

//        Path toOurContactsPlace = Paths.get("src/contacts");
//
//        Path toOurDataFile = Paths.get(String.valueOf(toOurContactsPlace), "data.txt");

        Path toContacts = Paths.get("src/contacts-folder/contacts.txt");

        try {
            if(Files.notExists(toContacts)) {
                Files.createFile(toContacts);
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        //        Create directory
//        try {
//            if (Files.notExists(toOurContactsPlace)) {
//                Files.createDirectories(toOurContactsPlace);
//            }else {
//                System.out.println("The " + toOurContactsPlace + " directory already exists.");
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
    }



    public static List<String> contactInfo = new ArrayList<>();


    public static void createContact() {
       Input in = new Input();
       String userContactName = in.getString();
       int userContactNum = in.getInt();
       contactInfo.add(userContactName + " | " + userContactNum);
    }


    public static void main(String[] args) {


//        displayMenu();
//        createContact();
//        System.out.println(contactInfo);
        createPath();






//        input.getString();
//        Path contactsFolder = Paths.get("src/contacts");

//        Path contactsFile = Paths.get(String.valueOf(contactsFolder),"contacts.txt");

    }
}

