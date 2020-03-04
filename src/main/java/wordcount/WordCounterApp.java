package wordcount;

import java.io.IOException;

import wordcount.io.console.Console;
import wordcount.io.console.ConsoleInterface;

public class WordCounterApp {

	private static ConsoleInterface console = new Console();
	private static WordCounter counter = new WordCounter();
	
	public static void main(String[] args) throws IOException {
		String input = console.getInput("Enter text: ");
		console.write("Number of words: " + counter.countWords(input));
	}

}
