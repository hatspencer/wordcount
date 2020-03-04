package wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
	
	private List<String> exclusionWords;
	
	public WordCounter(List<String> exclusionWords) {
		super();
		this.exclusionWords = exclusionWords;
	}

	public int countWords(String input) {
		return (int) getWordsStream(input).count();
	}
	
	public int countUniqueWords(String input) {
		return (int) getWordsStream(input).distinct().count();
	}
	
	private Stream<String> getWordsStream(String input) {
		if (input == null || input.trim().isEmpty()) {
			return Stream.empty();
		}
		Stream<String> stream = Arrays.asList(input.split("[ -]")).stream()
						.filter(block -> isValidWord(block))
						.filter(block -> !exclusionWords.contains(block));
		return stream;
	}

	private boolean isValidWord(String block) {
		if (block.isEmpty())
			return false;
		for (char c : block.toCharArray()) {
			if (!isLetter(c))
				return false;
		}
		return true;
	}
	
	private boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '.';
	}
	
}
