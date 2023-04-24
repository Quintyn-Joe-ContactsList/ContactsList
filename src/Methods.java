import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Methods {

	// method to list all contacts
	public static void listContacts(Path pathToFile) {
		try {
			List<String> contactsFromFile = Files.readAllLines(pathToFile);
			// System.out.println(groceryListFromFile);
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
}
