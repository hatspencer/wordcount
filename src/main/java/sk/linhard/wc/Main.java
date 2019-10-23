package sk.linhard.wc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {

	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

	public static void main(String[] args) {
		try {
			System.out.print("Enter text: ");
			Reader inputReader = createInputReader();
			Collection<String> stopWords = readStopWords();
			WordCounter wordCounter = new WordCounter(inputReader, stopWords);
			int count = wordCounter.count();
			System.out.print("Number of words: " + count);
		} catch (Throwable e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	private static Collection<String> readStopWords() throws IOException {
		return Files.lines(Paths.get(STOPWORDS_FILE_NAME), UTF_8).collect(Collectors.toList());
	}

	private static Reader createInputReader() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, UTF_8));
		return new StringReader(reader.readLine());
	}
}
