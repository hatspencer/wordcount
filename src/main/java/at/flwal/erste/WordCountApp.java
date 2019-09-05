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
	static final String RESULT_PREFIX = "Number of words: ";

	public static void main(String[] args) {

		Mode mode = Mode.fromArgs(args);
		Set<String> stopwords = loadStopwords(Paths.get("stopwords.txt"));
		WordCount wordCount = new WordCount(stopwords);
		callCount(args, mode, wordCount);
	}

	static Set<String> loadStopwords(Path path) {

		Set<String> stopwords = new HashSet<>();
		try (Scanner scanner = loadFromFile(path, "stopwords")) {

			while (scanner.hasNextLine()) {
				stopwords.add(scanner.nextLine());
			}
		}

		return stopwords;
	}

	private static String loadInputFile(Path path) {

		StringBuilder input = new StringBuilder();
		try (Scanner scanner = loadFromFile(path, "input")) {
			while (scanner.hasNextLine()) {
				input.append(scanner.nextLine()).append(WordCount.DELIMITER_SAMPLE);
			}
		}

		return input.toString();
	}

	private static Scanner loadFromFile(Path path, String s) {

		if (path == null) {
			throw new IllegalArgumentException(s + " file is mandatory.");
		}

		InputStream inputStream;
		try {
			inputStream = Files.newInputStream(path);
		} catch (IOException e) {
			throw new IllegalStateException("Could not find file for " + s, e);
		}
		return new Scanner(inputStream);
	}

	//TODO rethink call structure
	private static void callCount(String[] args, Mode mode, WordCount wordCount) {
		switch (mode) {
			case CLI:
				logic(System.in, System.out, wordCount);
				return;
			case FILE:
				logicWithInputFile(args[0], wordCount, System.out);
				return;
			default:
				throw new IllegalStateException("Unknown mode: " + mode);
		}
	}

	static void logic(InputStream in, PrintStream out, WordCount wordCount) {

		if (wordCount == null) {
			throw new IllegalArgumentException("Wordcounter not initialized.");
		}

		out.print(PROMPT_TEXT);

		Scanner input = new Scanner(in);
		String line = input.nextLine();
		int count = wordCount.count(line);

		out.print(RESULT_PREFIX);
		out.print(count);
	}

	static void logicWithInputFile(String arg, WordCount wordCount, PrintStream out) {

		String input = loadInputFile(Paths.get(arg));
		int count = wordCount.count(input);
		out.print(RESULT_PREFIX);
		out.print(count);
	}

}
