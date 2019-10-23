package sk.linhard.wc;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WordCountApp {

	private static final DecimalFormat AVG_FORMAT = new DecimalFormat("0.00");

	private Charset charset;
	private Reader inputReader;
	private Optional<File> stopWordsFile;

	public WordCountApp(Reader inputReader, Charset charset, Optional<File> stopWordsFile) {
		super();
		this.charset = charset;
		this.inputReader = inputReader;
		this.stopWordsFile = stopWordsFile;
	}

	private Collection<String> readStopWords() throws IOException {
		if (stopWordsFile.isEmpty()) {
			return Collections.emptyList();
		}
		try {
			return Files.lines(stopWordsFile.get().toPath(), charset).collect(Collectors.toList());
		} catch (NoSuchFileException e) {
			return Collections.emptyList();
		}
	}

	private WordCounter createCounter() throws IOException {
		Collection<String> stopWords = readStopWords();
		return new WordCounter(inputReader, stopWords);
	}

	public String computeOutput() throws IOException {
		WordCounter wordCounter = createCounter();
		int count = wordCounter.count();
		int uniqueCount = wordCounter.uniqueCount();
		double averageLength = wordCounter.averageLength();
		List<String> index = wordCounter.index();
		String countsLine = String.format("Number of words: %d, unique: %d; average word length: %s characters", count,
				uniqueCount, AVG_FORMAT.format(averageLength));

		return countsLine + "\nIndex:\n" + String.join("\n", index);
	}

}
