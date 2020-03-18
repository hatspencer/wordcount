import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CounterApp {

	public static final String fileName = "./src/stopwords.txt";
	
	public static void main(String[] args) {
		
		String message = readInput();
		List<String> excludedWords = new ArrayList<>();
		
		try {
			ExcludedWordsReader reader = new ExcludedWordsReaderImpl(fileName);
			excludedWords = reader.readFromFile();			
		}		
		catch (FileNotFoundException fileNotFoundException)  {
			fileNotFoundException.printStackTrace();
		}
		
		printWorldCountOutput(message, excludedWords);
	}

	private static void printWorldCountOutput(String message, List<String> excludedWords) {
		Counter counter = new WordCounter(message, excludedWords);
		int count =  counter.wordsCount();		
		
		System.out.println("Number of words: " + count);
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
