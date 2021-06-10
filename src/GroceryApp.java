import util.Input;

import java.util.HashMap;
import java.util.Scanner;

public class GroceryApp {

    public static String[] groceryCats = {
//        "Baby",
//        "Beverages",
//        "Bread & Bakery",
//        "Breakfast & Cereal",
        "Dairy, Eggs & Cheese",
        "Deli",
        "Frozen Foods",
        "Meat & Seafood",
        "Produce"
    };

    public static Input input = new Input();

    public static Scanner sc = new Scanner(System.in);

    public static HashMap<String, HashMap<String, Integer>> gList = new HashMap<>();

    public static void makeIt() {
        System.out.println("Would you like to create a grocery list?");
        if (input.yesNo()) {
            makeGroceryList();
        }
    }

    public static void makeGroceryList() {
        do {
            System.out.println("Which category would you like to choose from?");
            for (int i = 0; i < groceryCats.length; ++i) {
                System.out.println(i + 1 + ". " + groceryCats[i]);
            }

            int userNum = input.getInt(1, groceryCats.length);
            String userChoice = groceryCats[userNum - 1];
            System.out.println(userChoice);

            if (!gList.containsKey(userChoice)) {
                addCat(userChoice);
            }

            HashMap<String, Integer> selectedCat = gList.get(userChoice);

            do {
                addItemOrUpdateItemVal(selectedCat);
                System.out.println("Would you like to add another item from " + userChoice);
            } while (input.yesNo());

            System.out.println("Would you like to add more to the list?");
        } while (input.yesNo());

        System.out.println(gList);
    }

    public static void addItemOrUpdateItemVal(HashMap<String, Integer> items) {
        System.out.println("What item would you like to add?");
        String userInpItem = sc.nextLine();
        System.out.println("How many " + userInpItem + " would you like to add?");
        int userNum = input.getInt();
        if (items.containsKey(userInpItem)) {
            int oldVal = items.get(userInpItem);
            items.replace(userInpItem, oldVal + userNum);
        } else {
            items.put(userInpItem, userNum);
        }
    }

    public static void addCat(String key) {
        if (!gList.containsKey(key)) {
            gList.put(key, new HashMap<String, Integer>());
        }
    }


    public static void main(String[] args) {
//        HashMap<String, Integer> items = new HashMap<>();
//        items.put("Banana", 7);
//        gList.put(groceryCats[4], items);

        makeIt();
//        items.put("Strawberries", 7);
//
//        addItemOrUpdateItemVal(items);

//        System.out.println(items.get("Banana"));

//        updateVal(items, "Banana", 4);

//        System.out.println(items.get("Banana"));

        // this will display what is in the produce hash map key value
//        System.out.println(gList.get("Produce"));

        // this will display the value of strawberries within the hash map key value within the produce hashmap key value
//        System.out.println(gList.get("Produce").get("Strawberries"));
//        System.out.println(gList.get("Produce").keySet());

    }
}
