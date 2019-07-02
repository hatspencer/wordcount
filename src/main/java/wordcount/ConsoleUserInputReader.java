package wordcount;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {

	private final InputStream inputStream;
	
	public ConsoleUserInputReader() {
		this(System.in);
	}
	
	ConsoleUserInputReader(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public Collection<String> readUserInput() {
		System.out.print("Enter text:");
		final Scanner scanner = new Scanner(inputStream);
		final String line = scanner.nextLine();
		scanner.close();
		
		return Collections.singletonList(line);
	}

}
