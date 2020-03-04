package wordcount;

import java.io.IOException;
import java.nio.file.Paths;

import wordcount.exclusions.ExclusionLoader;
import wordcount.exclusions.FileExclusionLoader;
import wordcount.input.FileInputProvider;
import wordcount.io.console.Console;
import wordcount.io.console.ConsoleInterface;

public class WordCounterApp {

	private static ConsoleInterface console = new Console();
	private static ExclusionLoader exclusionLoader = new FileExclusionLoader(Paths.get("stopwords.txt"));
	private static WordCounter counter = new WordCounter(exclusionLoader.loadExclusions());
	
	public static void main(String[] args) throws IOException {
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

}
