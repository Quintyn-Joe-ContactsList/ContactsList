import util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Contact {

    private String directory = "data";
    private String filename = "contacts.txt";
    private String contactMenu = """
            1. View contacts.
            2. Add a new contact.
            3. Search a contact by name.
            4. Delete an existing contact.
            5. Exit.
            """;
	Path dataDirectory = Paths.get(directory);
	Path dataFile = Paths.get(directory, filename);

//    MAIN METHOD
    public void mainMethod() {
        CreateFile.createFile(dataDirectory, dataFile);
        while(true) {
			utils.printHeading("Contacts Manager");
            System.out.println(contactMenu);
            int menuOption = Input.getInt("Please select an option:", 1, 5);
            if (menuOption == 5) {
                System.out.println("Goodbye");
                break;
            }
            switch (menuOption) {
                case 1 -> {
//              View contacts
					Methods.listContacts(dataFile);
                }
                case 2 -> {
//              Add a new contact
                    Methods.addContact(dataFile);
                }
                case 3 -> {
//              Search a contact by name
					Methods.searchContacts(dataFile);
                }
                case 4 -> {
//              Delete an existing contact
                    Methods.removeContacts(dataFile);
                }
            }
        }
    }
}

