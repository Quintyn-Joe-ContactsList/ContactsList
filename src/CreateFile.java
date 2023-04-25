import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class CreateFile {
	public static void createFile(Path data, Path file) {
		if (Files.notExists(data)) {
			try {
				Files.createDirectories(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (Files.notExists(file)) {
			try {
				Files.createFile(file);
				List<String> contactList = Arrays.asList(
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
				Files.write(file, contactList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
