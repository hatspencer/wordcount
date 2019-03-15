import api.InputProvider;
import api.WordCounter;
import api.WordFilter;
import api.WordsProvider;
import impl.*;

public class WordCountApplication {

	public static void main(String[] args) {

		InputProvider inputProvider = new ConsoleInput();
		if (args != null && args.length == 1) {
			inputProvider = new FileInput(args[0]);
		}

		WordCounter allWordsCounter = new AllWordsCounter();
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();

		WordsProvider wordsProvider = new GetWordsByRegexBoundary();
		WordFilter wordFilter = new StopWordsFilter();

		String input = inputProvider.getInput();

		int wordCount = allWordsCounter.count(input, wordsProvider, wordFilter);
		int uniqueWordCount = uniqueWordsCounter.count(input, wordsProvider, wordFilter);

		System.out.println("Number of words: " + wordCount + ", unique: " + uniqueWordCount);
	}
}