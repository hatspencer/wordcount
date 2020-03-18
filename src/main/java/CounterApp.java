import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CounterApp {

	//public static final String inputFileName = "./src/inputText.txt";
	public static final String fileName = "./src/stopwords.txt";
	
	public static void main(String[] args) {
			
		String message = null;
		if(args.length > 0 && args[0] != null) {
			message = getTextFromFile(args);		
		}
		else {
			message = readInput();
		}
		
		execute(message);
	}

	private static void execute(String message) {
		List<String> excludedWords = new ArrayList<>();
		
		try {
			WordsReader reader = new ExcludedWordsReaderImpl(fileName);
			excludedWords = reader.readFromFile();			
		}		
		catch (FileNotFoundException fileNotFoundException)  {
			fileNotFoundException.printStackTrace();
		}
		
		printWorldCountOutput(message, excludedWords);
	}

	private static String getTextFromFile(String[] args) {
		System.out.println("Enter file name!");
		String message;
		WordsReader inputReader = new FileInputTextReader(args[0]);
		List<String> inputList = inputReader.readFromFile();
		
		StringBuilder sb = new StringBuilder();			
		inputList.forEach(line -> sb.append(line).append(" "));		
		message = sb.toString();
		return message;
	}

	private static void printWorldCountOutput(String message, List<String> excludedWords) {
		Counter counter = new WordCounter(message, excludedWords);
		int count =  counter.wordsCount();
		
		int uniqueWordsCount = counter.getUniqueWordsCount();
		
		System.out.println("Number of words: " + count + 
				           ", unique: " + uniqueWordsCount);
	}

	private static String readInput() {
		System.out.println("Enter text: ");		
		
		String message;
		try (Scanner scanner = new Scanner(System.in)) {			
			message = scanner.nextLine();
		}
			
		return message;
	}

}
