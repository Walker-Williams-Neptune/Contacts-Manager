import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactsManager {
    public static void main(String[] args) {
        Path contactsFolder = Paths.get("src/contacts");

        Path contactsFile = Paths.get(String.valueOf(contactsFolder),"contacts.txt");

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