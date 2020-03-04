package wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCounter {
	
	public int countWords(String input) {
		return countWords(input, new ArrayList<>());
	}

	public int countWords(String input, List<String> exclusionWords) {
		if (input == null || input.trim().isEmpty()) {
			return 0;
		}
		return (int) Arrays.asList(input.split(" ")).stream()
						.filter(block -> isValidWord(block))
						.filter(block -> !exclusionWords.contains(block))
						.count();
	}

	private boolean isValidWord(String block) {
		if (block == null || block.isEmpty())
			return false;
		for (char c : block.toCharArray()) {
			if (!isLetter(c))
				return false;
		}
		return true;
	}
	
	private boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
}
