import api.InputProvider;
import api.WordCounter;
import impl.ConsoleInput;
import impl.RegexCounter;

public class WordCountApplication {

	public static void main(String[] args) {

		InputProvider inputProvider = new ConsoleInput();
		WordCounter wordCounter = new RegexCounter();

		String input = inputProvider.getInput();
		int wordCount = wordCounter.count(input);

		System.out.println("Number of words: " + wordCount);
	}
}