package wordcount;

import java.io.IOException;

import wordcount.io.console.Console;
import wordcount.io.console.ConsoleInterface;

public class WordCounterApp {

	private static ConsoleInterface console = new Console();
	
	public static void main(String[] args) throws IOException {
		console.getInput("Enter text:");
		console.write("");
	}

}
