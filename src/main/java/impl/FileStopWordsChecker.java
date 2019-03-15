package impl;

import api.StopWordChecker;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileStopWordsChecker implements StopWordChecker {

	private Set<String> stopWords;

	public FileStopWordsChecker() throws IOException {
		initializeStopWords(getDefaultFileReader());
	}

	public FileStopWordsChecker(String fileName) throws IOException {
		initializeStopWords(new BufferedReader(new FileReader(fileName)));
	}

	private void initializeStopWords(BufferedReader reader) throws IOException {
		if (reader == null) {
			System.err.println("No file reader provided.");
			// TODO handle
		}

		stopWords = new HashSet<>();
		String line;
		while ((line = reader.readLine()) != null) {
			stopWords.add(line.trim());
		}
	}

	private BufferedReader getDefaultFileReader() {
		String defaultStopWordsFileName = "/stopwords.txt";
		InputStream stream = FileStopWordsChecker.class.getResourceAsStream(defaultStopWordsFileName);
		if (stream == null) {
			return null;
		}

		return new BufferedReader(new InputStreamReader(stream));
	}

	@Override
	public boolean isStopWord(String word) {
		return stopWords.contains(word);
	}
}