package wordcount;

import static java.util.Collections.unmodifiableCollection;
import static wordcount.UserInputReaderFactory.createUserInputReaderFrom;

import java.util.Collection;

public class Start {
	
	private static final String STOP_WORDS_FILE = "stopwords.txt";
	
	public static void main(String[] args) {
		final UserInputReader userInputReader = createUserInputReaderFrom(args);
		final Collection<String> userInput = unmodifiableCollection(userInputReader.readUserInput());
		
		final long wordCount = countWords(userInput);
		System.out.println(String.format("Number of words: %d", wordCount));
	}
	
	static long countWords(Collection<String> userInput) {
		final FileLinesReader stopWordsReader = new FileLinesReader(STOP_WORDS_FILE);
		final StopWordsFilter stopWordsFilter = new StopWordsFilter(stopWordsReader.readLines());
		return new WordCounter(stopWordsFilter).countWordsOf(userInput);
	}
}
