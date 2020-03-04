package wordcount;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import wordcount.exlusions.ExclusionLoader;
import wordcount.exlusions.FileExclusionLoader;
import wordcount.io.console.Console;
import wordcount.io.console.ConsoleInterface;

public class WordCounterApp {

	private static ConsoleInterface console = new Console();
	private static WordCounter counter = new WordCounter();
	private static ExclusionLoader exclusionLoader = new FileExclusionLoader(Paths.get("stopwords.txt"));
	
	public static void main(String[] args) throws IOException {
		List<String> exceptions = exclusionLoader.loadExclusions();
		String input = console.getInput("Enter text: ");
		console.write("Number of words: " + counter.countWords(input, exceptions));
	}

}