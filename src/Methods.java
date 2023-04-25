import util.Input;
import util.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
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
	}

	// method to search for a contact
	public static void searchContacts(Path pathToFile, String searchTerm) {
		try {
			List<String> contactsFromFile = Files.readAllLines(pathToFile);
			for (int i = 0; i <= contactsFromFile.size(); i++) {
				if (contactsFromFile.get(i).toLowerCase().contains(searchTerm.toLowerCase())) {
					System.out.println(contactsFromFile.get(i));
					break;
				} else if (!contactsFromFile.get(contactsFromFile.size() - 1).toLowerCase().contains(searchTerm.toLowerCase())) {
					System.out.println("No contacts found.");
					break;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	//	Method to add contacts
	public static void addContact (Path pathtoFile, String first, String last, String phone) {
		try {
			List <String> newContact= Arrays.asList("First: " + first +", Last: " + last + ", Number: " + phone);
			Files.write(
					pathtoFile,
					newContact,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	//	Method to remove contacts
	public static void removeContacts(Path pathToFile, String searchTerm) {
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
			Methods.removeContacts(pathToFile, Input.getString("Please enter a name to search for:"));
		}
	}
}


