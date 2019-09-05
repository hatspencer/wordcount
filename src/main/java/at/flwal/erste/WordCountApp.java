package at.flwal.erste;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;

public class WordCountApp {

	static final String PROMPT_TEXT = "Enter text: ";
	static final String RESULT_TEXT = "Number of words: ";

	public static void main(String[] args) {
		logic(System.in, System.out);
	}

	static void logic(InputStream in, PrintStream out) {

		out.print(PROMPT_TEXT);

		Scanner input = new Scanner(in);
		String line = input.nextLine();
		WordCount wordCount = new WordCount(Collections.<String>emptySet());
		int count = wordCount.count(line);

		out.print(RESULT_TEXT);
		out.print(count);
	}

}
