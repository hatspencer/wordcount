package wordcount;

import java.io.IOException;
import java.nio.file.Paths;

import wordcount.exclusions.ExclusionLoader;
import wordcount.exclusions.FileExclusionLoader;
import wordcount.input.FileInputProvider;
import wordcount.io.console.Console;
import wordcount.io.console.ConsoleInterface;

public class WordCounterApp {

	private ConsoleInterface console;
	private WordCounter counter;
	private String[] args;
	
	public WordCounterApp(ConsoleInterface console, WordCounter counter, String[] args) {
		this.console = console;
		this.counter = counter;
		this.args = args;
	}
	
	public void execute() throws IOException {
		String input;
		if (args.length > 0) {
			try {
				input = new FileInputProvider(args[0]).getInput();
			} catch (IOException io) {
				console.write("Error reading configured file, enter text manually");
				input = console.getInput("Enter text: ");
			}
		} else {
			input = console.getInput("Enter text: ");
		}
		console.write("Number of words: " + counter.countWords(input) + ", unique:" + counter.countUniqueWords(input));
	}

	public static void main(String[] args) throws IOException {
		ExclusionLoader exclusionLoader = new FileExclusionLoader(Paths.get("stopwords.txt"));
		WordCounterApp app = new WordCounterApp(new Console(), new WordCounter(exclusionLoader.loadExclusions()), args);
		app.execute();
	}

}
