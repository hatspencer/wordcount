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
		if (!stopWordsFile.isPresent()) {
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

	private String formatCountsLine(WordCounter wordCounter) {
		int count = wordCounter.count();
		int uniqueCount = wordCounter.uniqueCount();
		double averageLength = wordCounter.averageLength();
		return String.format("Number of words: %d, unique: %d; average word length: %s characters", count, uniqueCount,
				AVG_FORMAT.format(averageLength));
	}

	public String computeOutput() throws IOException {
		return formatCountsLine(createCounter());
	}

	public String computeOutputWithIndex() throws IOException {
		WordCounter wordCounter = createCounter();
		return formatCountsLine(wordCounter) + "\nIndex:\n" + String.join("\n", wordCounter.index());
	}

}
