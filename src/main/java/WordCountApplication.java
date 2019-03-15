import api.InputProvider;
import api.WordCounter;
import impl.ConsoleInput;
import impl.FileStopWordsChecker;
import impl.RegexCounter;

import java.io.IOException;

public class WordCountApplication {

	public static void main(String[] args) throws IOException {

		InputProvider inputProvider = new ConsoleInput();
		WordCounter wordCounter = new RegexCounter();

		String input = inputProvider.getInput();
		int wordCount = wordCounter.count(input, new FileStopWordsChecker());

		System.out.println("Number of words: " + wordCount);
	}
}