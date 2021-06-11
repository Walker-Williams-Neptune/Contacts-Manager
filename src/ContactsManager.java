import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsManager {
    // Array of menu options.
    public static String[] menuOptions = {
        "View contacts.",
        "Add a new contact.",
        "Search a contact by name.",
        "Delete an existing contact.",
        "Exit."
    };

    // Path to contacts.txt file.
    private static final Path toContacts = Paths.get("src/contacts-folder/contacts.txt");

    // Polymorphic ArrayList we use to store our contacts.txt file contents in.
    private static List<String> currentList = new ArrayList<>();

    // This method reads the contacts.txt file and updates our currentList ArrayList.
    public static void readFileAndUpdateCurrentList () {
        try {
            currentList = Files.readAllLines(toContacts);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method searches currentList for user input name.
    public static void searchForContact() {
        Input in = new Input();
        System.out.println("Search for contact.");
        String userSearch = in.getString();
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.toLowerCase(Locale.ROOT).contains(userSearch.toLowerCase(Locale.ROOT))) {
                System.out.println(contact);
            }
        }
    }
    // This method searches currentList for contact to remove then removes it from currentList upon confirmation.
    public static void removeContact() {
        Input in = new Input();
        System.out.println("Enter contact you want to remove.");
        String userSearch = in.getString();
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.toLowerCase(Locale.ROOT).contains(userSearch.toLowerCase(Locale.ROOT))) {
                System.out.println("Would you like to remove?: " + contact);
                if (in.yesNo()) {
                    System.out.println("Are you sure you want to remove?: " + contact);
                    if (in.yesNo()) {
                        System.out.println(contact + " was removed.");
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }
    // This method writes our currentList to our contacts.txt file.
    public static void writeToContacts() {
        try {
            Files.write(toContacts, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    // This method creates a new contact and adds it to our contacts.txt file.
    public static void addToContacts() {
        Input in = new Input();
        String userContactName = in.getString();
        int userContactNum = in.getInt();
        String contact;
        if (currentList.isEmpty()) {
            contact = userContactName + " | " + userContactNum;
        }else {
            contact = "\n" + userContactName + " | " + userContactNum;
        }
        try {
            Files.writeString(toContacts, contact, StandardOpenOption.APPEND);
            System.out.println("Successfully created contact: " + contact);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    // This method will return to main menu if the user chooses to.
    public static void returnToMenu() {
        Input in = new Input();
        System.out.println("Would you like to return to main menu? Yes for main menu or no for exit.");
        if (in.yesNo()) {
            displayMenu();
        }
    }
    // This method runs the contact manager program by displaying the menu and asking for user input and executing methods
    // based on user input.
    public static void displayMenu() {
        Input in = new Input();
        for (int i = 0; i < menuOptions.length; ++i) {
            System.out.println(i + 1 + ". " + menuOptions[i]);
        }

        // This uses getInt to get an user input number based on the length of menu options starting at 1
        int userNum = in.getInt(1, menuOptions.length);

        readFileAndUpdateCurrentList();
        switch (userNum) {
            case 1:
                System.out.println("Name | Phone number\n---------------");
                for (String list : currentList) {
                    System.out.println(list);
                }
                returnToMenu();
                break;
            case 2:
                addToContacts();
                returnToMenu();
                break;
            case 3:
                searchForContact();
                returnToMenu();
                break;
            case 4:
                removeContact();
                writeToContacts();
                returnToMenu();
                break;
            case 5:
                System.out.println("See you later!");
                break;
            default:
                System.out.println("Invalid option, try again");
                break;
        }
    }
    public static void main(String[] args) {
        displayMenu();
    }
}



// Not in use, we used this code to create our directory/folder and our text file for this project initially.
// private static final Path toOurContactsFolder = Paths.get("src/contacts-folder");
//    public static void createPath() {
////        Directory
//        try {
//            if (Files.notExists(toOurContactsFolder)) {
//                Files.createDirectory(toOurContactsFolder);
//            }else {
//                System.out.println("The " + toOurContactsFolder + " Directory already exists");
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
////        File
//        try {
//            if(Files.notExists(toContacts)) {
//                Files.createFile(toContacts);
//            }else {
//                System.out.println("File already exists");
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
