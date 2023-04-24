package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private boolean hold;

    public Input() {
        this.scanner = new Scanner(System.in);
    }
    public String getString() {
        return scanner.nextLine();
    }
    public boolean yesNo() {
        String input = scanner.next();
        if (input.startsWith("y")) {
            hold = true;
        } else if (input.startsWith("n")) {
            hold = false;
        }
        return hold;
    }
    public int getInt(int min, int max) {
        try {
            System.out.printf("Input a number between %d and %d \n", min, max);
            String inputNum = getString();
            boolean inRange = Integer.parseInt(inputNum) < max && Integer.parseInt(inputNum) > min;
            if (inRange == true) {
                return Integer.parseInt(inputNum);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return getInt(min, max);
    }
    public int getInt() {
        try {
            String intInput = getString();
            return Integer.parseInt(intInput);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return getInt();
    }
    public double getDouble(double min, double max) {
        try {
            System.out.printf("Input a number between %.2f and %.2f\n", min, max);
            String inputNum = getString();
            boolean inRange = Double.parseDouble(inputNum) < max && Double.parseDouble(inputNum) > min;
            if (inRange == true) {
                return Double.parseDouble(inputNum);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return getDouble(min, max);
    }
    public double getDouble() {

        try {
            String dubInput = getString();
            return Double.parseDouble(dubInput);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return getDouble();

    }

}
