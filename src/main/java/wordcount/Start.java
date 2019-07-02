package wordcount;

import java.util.Scanner;

public class Start {
	
	private static final String STOP_WORDS_FILE = "stopwords.txt";
	
	public static void main(String[] args) {
		System.out.print("Enter text:");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();

		
		final long wordCount = countWords(line);
		System.out.println(String.format("Number of words: %d", wordCount));
	}
	
	static long countWords(String line) {
		final StopWordsReader stopWordsReader = new StopWordsReader(STOP_WORDS_FILE);
		final StopWordsFilter stopWordsFilter = new StopWordsFilter(stopWordsReader.readStopWords());
		return new WordCounter(stopWordsFilter).countWordsOf(line);
	}
}
