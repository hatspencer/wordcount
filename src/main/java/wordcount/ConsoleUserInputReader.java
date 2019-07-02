package wordcount;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {

	@Override
	public Collection<String> readUserInput() {
		System.out.print("Enter text:");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		
		return Collections.singletonList(line);
	}

}
