package at.flwal.erste;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCountApp {

	static final String PROMPT_TEXT = "Enter text: ";
	static final String RESULT_TEXT = "Number of words: ";

	public static void main(String[] args) {
		WordCount wordCount = loadWordCounter(Paths.get("stopwords.txt"));
		logic(System.in, System.out, wordCount);
	}

	static WordCount loadWordCounter(Path pathToStopWords) {

		if(pathToStopWords == null) {
			throw new IllegalArgumentException("Stopwords file is mandatory.");
		}

		InputStream inputStream;
		try {
			inputStream = Files.newInputStream(pathToStopWords);
		} catch (IOException e) {
			throw new IllegalStateException("Could not find stopwords file", e);
		}
		Scanner scanner = new Scanner(inputStream);

		Set<String> stopwords = new HashSet<>();
		while (scanner.hasNextLine()) {
			stopwords.add(scanner.nextLine());
		}

		return new WordCount(stopwords);
	}

	static void logic(InputStream in, PrintStream out, WordCount wordCount) {

		if(wordCount == null) {
			throw new IllegalArgumentException("Wordcounter not initialized.");
		}

		out.print(PROMPT_TEXT);

		Scanner input = new Scanner(in);
		String line = input.nextLine();
		int count = wordCount.count(line);

		out.print(RESULT_TEXT);
		out.print(count);
	}

}
