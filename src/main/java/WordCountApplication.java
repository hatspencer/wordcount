import api.InputProvider;
import api.WordCounter;
import impl.ConsoleInput;
import impl.FileInput;
import impl.FileStopWordsChecker;
import impl.RegexCounter;

public class WordCountApplication {

	public static void main(String[] args) {

		InputProvider inputProvider = new ConsoleInput();
		if (args != null && args.length == 1) {
			inputProvider = new FileInput(args[0]);
		}

		WordCounter wordCounter = new RegexCounter();

		String input = inputProvider.getInput();
		int wordCount = wordCounter.count(input, new FileStopWordsChecker());

		System.out.println("Number of words: " + wordCount);
	}
}