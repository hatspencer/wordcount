package wordcount.service;

import java.util.Arrays;
import java.util.stream.Stream;

public class WordCountService {

	protected static Stream<String> getStreamOfWords(String input) {
		return Arrays.stream(input.split("\\s+")).filter(w -> w.matches("[a-zA-Z]+"));
	}
	
	public static long getWordCount(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		return getStreamOfWords(input).count();
	}

	public static long getWordCount(String input, WordExclusionComponent component) {
		if (input == null || input.length() == 0 || component == null) {
			return 0;
		}
		return getStreamOfWords(input).filter(w -> !component.isWordExcluded(w)).count();
	}
}
