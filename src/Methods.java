import util.Input;
import util.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Methods {

	// method to list all contacts
	public static void listContacts(Path pathToFile) {
		try {
			List<String> contactsFromFile = Files.readAllLines(pathToFile);
			for (String contact : contactsFromFile) {
				System.out.println(contact);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		utils.waitForUser();
		utils.clearConsole();
	}

	// method to search for a contact
	public static void searchContacts(Path pathToFile) {
		String searchTerm = Input.getString("Please enter a name to search for:");
		try {
			List<String> contactsFromFile = Files.readAllLines(pathToFile);
			for (String contact : contactsFromFile) {
				if (contact.toLowerCase().contains(searchTerm.toLowerCase())) {
					System.out.println(contact);
					break;
				}
			}
			if (!contactsFromFile.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
				System.out.println("No contacts found.");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		if (Input.yesNo("Would you like to search again? [y/n]")) {
			Methods.searchContacts(pathToFile);
		}
		utils.clearConsole();
	}

	//	Method to add contacts
	public static void addContact (Path pathToFile) {
		utils.clearConsole();
		String first = Input.getString("Please enter a First Name");
		utils.clearConsole();
		String last = Input.getString("Please enter a Last Name");
		utils.clearConsole();
		String phone = Input.getString("Please enter a Phone Number");
		utils.clearConsole();
		try {
			List <String> newContact=
					List.of("First: " + first + ", Last: " + last + ", Number: " + formatNumber(phone));
			Files.write(
					pathToFile,
					newContact,
					StandardOpenOption.APPEND);
			System.out.println("Contact added.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		utils.waitForUser();
		utils.clearConsole();
    }

	//	Method to remove contacts
	public static void removeContacts(Path pathToFile) {
		String searchTerm = Input.getString("Please enter a name to search for:");
		try {
			List<String> contacts = Files.readAllLines(pathToFile);
			List<String> newList = new ArrayList<>();
			for (String contact : contacts) {
				if (!contact.toLowerCase().contains(searchTerm.toLowerCase())) {
					newList.add(contact);
				}
			}
			Files.write(pathToFile, newList);
			if (contacts.size() == newList.size()) {
				System.out.println("No contacts found.");
			} else {
				System.out.println("Contact removed.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Input.yesNo("Would you like to remove another contact? [y/n]")) {
			Methods.removeContacts(pathToFile);
		}
		utils.waitForUser();
		utils.clearConsole();
	}

	public static String formatNumber(String inputPhone) {
		String formatPhone = "";

		if (inputPhone.length() == 10) {
			formatPhone += inputPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		} else if (inputPhone.length() == 7) {
			formatPhone += inputPhone.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
		}

		return formatPhone;
	}

}


