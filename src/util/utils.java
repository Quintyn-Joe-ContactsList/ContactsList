package util;

import java.util.Scanner;

public class utils {
	public static Scanner scanner = new Scanner(System.in);
	public static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	// This method is used to clear the console.
	public static void clearConsole () {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	//Method to print a separator with length of n
	public static void printSeparator(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	//Additional method to print a separator with length of n with different style
	public static void printSeparatorAlt(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	// method to print a heading
	public static void printHeading(String title) {
		printSeparator(title.length());
		printSeparatorAlt(title.length());
		System.out.println(title);
		printSeparatorAlt(title.length());
		printSeparator(title.length());
	}

	// method to stop the game until the user presses any key
	public static void waitForUser() {
		System.out.println("\nPress Enter to continue...");
		scanner.nextLine();
	}
}
