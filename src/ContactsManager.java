import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    private static final Path toOurContactsPlace = Paths.get("src/contacts-folder");
    private static final Path toContacts = Paths.get("src/contacts-folder/contacts.txt");

    private static List<String> currentList = new ArrayList<>();

    public static void readFileAndUpdateCurrentList (Path pathToFile) {
        try {
            currentList = Files.readAllLines(pathToFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createPath() {
//        Directory
        try {
            if (Files.notExists(toOurContactsPlace)) {
                Files.createDirectory(toOurContactsPlace);
            }else {
                System.out.println("The " + toOurContactsPlace + " Directory already exists");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

//        File
        try {
            if(Files.notExists(toContacts)) {
                Files.createFile(toContacts);
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToContacts() {
        try {
            Files.writeString(toContacts, createContact(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> contactInfo = new ArrayList<>();

    public static String createContact() {
       Input in = new Input(); // instantiate new input to use for createContact
       String userContactName = in.getString();
       int userContactNum = in.getInt();
       contactInfo.add(userContactName + " | " + userContactNum);
       return "\n" + userContactName + " | " + userContactNum;
    }


    public static void main(String[] args) {
//        displayMenu();
//        createContact();
//        System.out.println(contactInfo);
//        createPath();
//        addToContacts();
        System.out.println(currentList);
        readFileAndUpdateCurrentList(toContacts);
        System.out.println(currentList);

    }
}

