package wordcount;

import java.util.Scanner;

public class Start {
	
	private static final String STOP_WORDS_FILE = "stopwords.txt";
	
	public static void main(String[] args) {
		System.out.print("Enter text:");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();

		final StopWordsReader stopWordsReader = new StopWordsReader(STOP_WORDS_FILE);
		final long wordCount = new WordCounter(new StopWordsFilter(stopWordsReader.readStopWords())).countWordsOf(line);
		System.out.println(String.format("Number of words: %d", wordCount));
	}
}
