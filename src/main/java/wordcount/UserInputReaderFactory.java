package wordcount;

public class UserInputReaderFactory {
	public static UserInputReader createUserInputReaderFrom(String[] consoleArguments) {
		if(consoleArguments.length > 1) {
			throw new IllegalArgumentException("Too many arguments");
		}
		
		if(consoleArguments.length == 1) {
			return new FileUserInputReader(new FileLinesReader(consoleArguments[0]));
		}
		
		return new ConsoleUserInputReader();
	}
}
