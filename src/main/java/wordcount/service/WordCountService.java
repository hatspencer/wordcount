package wordcount.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import wordcount.dto.WordCountResult;

public class WordCountService {

	public static Stream<String> getStream(String inputLine) {
		return Arrays.stream(inputLine.split("[\\s\\-]+")).filter(w -> w.matches("[a-zA-Z]+\\.?"));
	}
	
	public static Stream<String> getStream(Path inputFile) {
		Stream<String> stream = new LinkedList<String>().stream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile.toFile())))) {
			String line;
			while ((line = reader.readLine()) != null) {
				stream = Stream.concat(stream, getStream(line));
			}
		} catch (Exception e) {
		}
		return stream;
	}
	
	public static Set<String> getStopWords(Path path) {
		try {
			return new HashSet<>(Files.readAllLines(path));
		} catch (IOException e) {
		}
		return new HashSet<>();
	}

	public static WordCountResult getResult(String inputLine) {
		return getResult(getStream(inputLine), Collections.emptySet());
	}
	
	public static WordCountResult getResult(Path inputFile) {
		Stream<String> stream = getStream(inputFile);
		return getResult(stream, Collections.emptySet());
	}

	public static WordCountResult getResult(Stream<String> stream, Set<String> stopWords) {
		List<String> words = stream.filter(w -> !stopWords.contains(w)).collect(Collectors.toList());
		Set<String> uniqueWords = new HashSet<>(words);
		return new WordCountResult(words.size(), uniqueWords.size());
	}

	public static long getWordCount(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		return getStream(input).count();
	}

	public static long getWordCountFromFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
			String line;
			long wordCount = 0l;
			while ((line = reader.readLine()) != null) {
				wordCount += WordCountService.getWordCount(line);
			}
			return wordCount;
		} catch (Exception e) {
			return -1l;
		}

	}
}
