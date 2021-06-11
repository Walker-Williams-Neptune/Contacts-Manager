import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

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

        readFileAndUpdateCurrentList(toContacts);
        switch (userNum) {
            case 1:
                System.out.println("Name | Phone number\n---------------");
                for (String list : currentList) {
                    System.out.println(list);
                }
                returnMenu();
                break;
            case 2:
                addToContacts();
                returnMenu();
                break;
            case 3:
                System.out.println("This is case 3");
                searchForContact();
                returnMenu();
                break;
            case 4:
                System.out.println("This is case 4");
                removeContact();
                writeToContacts();
                returnMenu();
                break;
            case 5:
                System.out.println("See you later!");
                break;
            default:
                System.out.println("Invalid option, try again");
                break;
        }
//        String userChoice = menuOptions[userNum - 1];

//        System.out.println(userChoice);

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

    public static void returnMenu() {
        Input in = new Input();
        System.out.println("Would you like to return to main menu?");
        if (in.yesNo()) {
            displayMenu();
        }
    }

    public static void writeToContacts() {
        try {
            Files.write(toContacts, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

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

//    public static List<String> contactInfo = new ArrayList<>();

    public static String createContact() {
       Input in = new Input(); // instantiate new input to use for createContact
       String userContactName = in.getString();
       int userContactNum = in.getInt();

       if (currentList.isEmpty()) {
           return userContactName + " | " + userContactNum;
       }else {
           return "\n" + userContactName + " | " + userContactNum;
       }

    }


    public static void main(String[] args) {
        displayMenu();
//        createContact();
//        System.out.println(contactInfo);
//        createPath();
//        addToContacts();
//        addToContacts();
//        System.out.println(currentList);
//        readFileAndUpdateCurrentList(toContacts);
//        System.out.println(currentList);
//        searchForContact();
//        searchForContact();
//        removeContact();
//        writeToContacts();
//        System.out.println(currentList);

    }
}

