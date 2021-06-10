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
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }
    public int getInt(){
        System.out.println("Enter a phone number.");
        return scanner.nextInt();
    }
    // Exception handling
    public int getIntStr() {
        System.out.println("Enter contact phone number.");
        try {
           return Integer.valueOf(getString());
        } catch (NumberFormatException nfe) {
            System.out.println("Enter a number please.");
            return getIntStr();
        }
    }
    public int getInt(int min, int max) {
        System.out.printf("Enter a number between %d and %d:%n", min, max);
        int userInputNum = scanner.nextInt();
        if (userInputNum > max || userInputNum < min) {
            System.out.println("Invalid input, Try again!");
            return getInt(min, max);
        } else {
            return userInputNum;
        }
    }
    public double getDouble(){
        System.out.println("Enter a number with a decimal.");
        return scanner.nextDouble();
    }
    // Exception handling
    public Double getDoubleStr() {
        System.out.println("Enter a decimal number.");
        try {
            return Double.valueOf(getString());
        } catch (NumberFormatException nfe) {
            System.out.println("Enter a decimal number please.");
            return getDoubleStr();
        }
    }
    public double getDouble(double min, double max) {
        System.out.printf("Enter a number with a decimal between %f and %f:%n", min, max);
        double userInputNum = scanner.nextDouble();
        if (userInputNum > max || userInputNum < min) {
            System.out.println("Invalid input, Try again!");
            return getDouble(min, max);
        } else {
            return userInputNum;
        }
    }

}
