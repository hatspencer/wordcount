package impl;

import api.WordFilter;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class StopWordsFilter implements WordFilter {

	private Set<String> stopWords;

	public StopWordsFilter() {
		try {
			initializeStopWords(getDefaultFileReader());
		} catch (IOException e) {
			System.err.println("Failed to initialize stop words checker with default file reader.");
			throw new RuntimeException(e);
		}
	}

	public StopWordsFilter(String fileName) {
		try {
			initializeStopWords(new BufferedReader(new FileReader(fileName)));
		} catch (IOException e) {
			System.err.println("Failed to initialize stop words checker with file reader for file '" + fileName + "'");
			throw new RuntimeException(e);
		}
	}

	private void initializeStopWords(BufferedReader reader) throws IOException {
		stopWords = new HashSet<>();
		if (reader == null) {
			System.err.println("Failed to obtain file reader, using empty stop words collection.");
			return;
		}

		String line;
		while ((line = reader.readLine()) != null) {
			stopWords.add(line.trim());
		}

		reader.close();
	}

	private BufferedReader getDefaultFileReader() {
		String defaultStopWordsFileName = "/stopwords.txt";
		InputStream stream = StopWordsFilter.class.getResourceAsStream(defaultStopWordsFileName);
		if (stream == null) {
			return null;
		}

		return new BufferedReader(new InputStreamReader(stream));
	}

	@Override
	public boolean accept(String word) {
		return !stopWords.contains(word);
	}
}