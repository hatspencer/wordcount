package at.flwal.erste;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCountApp {

	static final String PROMPT_TEXT = "Enter text: ";
	static final String RESULT_TEXT = "Number of words: ";

	public static void main(String[] args) {

		Mode mode = detectMode(args);
		Set<String> stopwords = loadStopwords(Paths.get("stopwords.txt"));
		WordCount wordCount = new WordCount(stopwords);
		callCount(mode, wordCount);
	}

	static Set<String> loadStopwords(Path path) {

		if(path == null) {
			throw new IllegalArgumentException("Stopwords file is mandatory.");
		}

		InputStream inputStream;
		try {
			inputStream = Files.newInputStream(path);
		} catch (IOException e) {
			throw new IllegalStateException("Could not find stopwords file", e);
		}
		Scanner scanner = new Scanner(inputStream);

		Set<String> stopwords = new HashSet<>();
		while (scanner.hasNextLine()) {
			stopwords.add(scanner.nextLine());
		}
		return stopwords;
	}

	private static void callCount(Mode mode, WordCount wordCount) {
		switch (mode) {
			case CLI:
				logic(System.in, System.out, wordCount);
				return;
			case FILE:
				throw new UnsupportedOperationException("not yet implemenetd");
			default:
				throw new IllegalStateException("Unknown mode: " + mode);
		}
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

	static Mode detectMode(String[] args) {

		if(args.length == 0){
			return Mode.CLI;
		}

		if(args.length == 1) {
			return Mode.FILE;
		}

		throw new IllegalArgumentException("Expected 0 or 1 arguments (inputfile name), but got: "+ args.length);
	}
}
