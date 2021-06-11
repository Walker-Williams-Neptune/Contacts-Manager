package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String getString() {
        System.out.println("Enter contact name.");
        return scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.println("Enter yes or no");
        String input = scanner.next();
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ye");
    }

    // Exception handling
    public int getInt() {
        System.out.println("Enter contact phone number.");
        try {
            String input = scanner.nextLine();
            if (input.length() == 7 || input.length() == 10) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid input. Enter a 7 or 10 digit phone number please. Ex: 5555555");
                return getInt();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Enter a 7 or 10 digit phone number please. Ex: 5555555");
            return getInt();
        }
    }
    public int getInt(int min, int max) {
        System.out.printf("Enter a number between %d and %d:%n", min, max);
        try {
        String userInputNum = scanner.nextLine();
        if (Integer.parseInt(userInputNum) > max || Integer.parseInt(userInputNum) < min) {
            System.out.println("Invalid input, Try again!");
            return getInt(min, max);
        } else {
            return Integer.parseInt(userInputNum);
        }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input, Try again!");
            return getInt(min, max);
        }
    }
}