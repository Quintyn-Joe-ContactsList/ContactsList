package util;

import java.util.Scanner;

public class Input {
	//Improve your Input class.
	//
	//Your getInt and getDouble methods should make sure that the value returned from the method is actually an int or
	// a double. You can do this by replacing the use of the Scanner nextInt() and nextDouble() methods with the existing
	// getString() method you created in a previous exercise using the following methods to convert the returned String
	// into the desired datatype:
	//
	//
	//Integer.valueOf(String s);
	//Double.valueOf(String s);
	//Note these methods will throw a NumberFormatException if the given input cannot be parsed as an int or double.
	// Your methods on the Input class should handle these exceptions, you can use a try-catch for this.
	//
	//Bonus
	//
	//Research the .valueOf method on the Integer class. You will find that it can also be used to parse integers in
	// different bases. Use this functionality to create two new methods, getBinary and getHex that will accept a string
	// that is a number in binary or hexadecimal.
	//
	//
	//Enter a binary number: 111
	//Your number is 7
	//
	//Enter a hexidecimal number: 10
	//Your number is 16

	private static Scanner scanner = new Scanner(System.in);

	public static String getString( ) {
		String input = scanner.nextLine();
		if (input.isBlank()) {
			return getString();
		} else {
			return input;
		}
	}

	public static String getString(String prompt) {
		System.out.println(prompt);
		return getString();
	}

	public static boolean yesNo() {
		String input = getString();
		if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
			return true;
		} else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
			return false;
		} else {
			System.out.println("Please enter yes or no.");
			return yesNo();
		}
	}

	public static boolean yesNo(String prompt) {
		System.out.println(prompt);
		return yesNo();
	}

	public static int getInt(int min, int max) {
		int input = getInt();
		try {
			while (input < min || input > max) {
				System.out.println("Please enter a number between " + min + " and " + max + ".");
				input = getInt();
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			return getInt(min, max);
		}
		return input;
	}

	public static int getInt() {
		try {
			return Integer.parseInt(getString());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			return getInt();
		}
	}

	public static int getInt(String prompt, int min, int max) {
		System.out.println(prompt);
		return getInt(min, max);
	}


	public static double getDouble(double min, double max) {
		double input = getDouble();
		try {
			while (input < min || input > max) {
				System.out.println("Please enter a number between " + min + " and " + max + ".");
				input = getDouble();
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			return getDouble(min, max);
		}
		return input;
	}

	public static double getDouble() {
		try {
			return Double.parseDouble(getString());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid number.");
			return getDouble();
		}
	}

	public static double getDouble(String prompt, double min, double max) {
		System.out.println(prompt);
		return getDouble(min, max);
	}

	public static int getBinary() {
		try {
			return Integer.valueOf(getString());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a binary number");
			return getBinary();
		}
	}

}
