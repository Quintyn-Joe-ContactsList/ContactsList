
import util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Contact {

//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//
//    public String getFirstName() {
//        return firstName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Contact(String firstName, String lastName, String phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//    }

    Input userInput = new Input();
    private String directory = "data";
    private String filename = "contacts.txt";
    private String contactMenu = """
            1. View contacts.
            2. Add a new contact.
            3. Search a contact by name.
            4. Delete an existing contact.
            5. Exit.
            """;

    private void createFile(Path data, Path file) {
        if (Files.notExists(data)) {
            try {
//              HighlyLikely to run with an exception
//          .˙. RUN TRY CATCH
                Files.createDirectories(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.notExists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List <String> contactList = Arrays.asList(
                "First: Emily, Last: Jones,  Number: (555) 123-4567",
                "First: Marcus, Last: Rodriguez,  Number: (555) 234-5678",
                "First: Samantha, Last: Lee,  Number: (555) 345-6789",
                "First: Matthew, Last: Chen,  Number: (555) 456-7890",
                "First: Olivia, Last: Martinez,  Number: (555) 567-8901",
                "First: Ethan, Last: Davis,  Number: (555) 678-9012",
                "First: Isabella, Last: Jackson,  Number: (555) 789-0123",
                "First: William, Last: Kim,  Number: (555) 890-1234",
                "First: Ava, Last: Patel,  Number: (555) 901-2345",
                "First: Jacob, Last: Garcia,  Number: (555) 012-3456"
        );
        try {
            Files.write(file, contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void addContact (Path data, Path file) {
//        try {
//            Files.write(data, oldContacts);
//            List <String> newContacts= Arrays.asList("");
//            Files.write(
////                Where
//                    data,
////                What
//                    newContacts,
////          Third arg for writing to open files
////                Do
//                    StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    MAIN METHOD
    public void mainMethod() {
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        createFile(dataDirectory, dataFile);
        while(true) {
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
					utils.waitForUser();
					utils.clearConsole();
                }
                case 2 -> {
//              Add a new contact
                }
                case 3 -> {
//              Search a contact by name
					Methods.searchContacts(dataFile, Input.getString("Please enter a name to search for:"));
					utils.waitForUser();
					utils.clearConsole();
					if (Input.yesNo("Would you like to search again? [y/n]")) {
						Methods.searchContacts(dataFile, Input.getString("Please enter a name to search for:"));
					} else {
						utils.clearConsole();
					}
                }
                case 4 -> {
//              Delete an existing contact
                }
            }
        }
    }

}
