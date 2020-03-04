package wordcount;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {
	
	public int countWords(String input) {
		return countWords(input, new ArrayList<>());
	}

	public int countWords(String input, List<String> exclusionWords) {
		if (input == null || input.trim().isEmpty()) {
			return 0;
		}
		int count = 0;
		for (String block : input.split(" ")) {
			if (isWord(block) && exclusionWords.contains(block))
				count++;
		}
		return count;
	}
		
	public int oldCountWords(String input, List<String> exclusionWords) {
		if (input == null || input.trim().isEmpty()) {
			return 0;
		}
		int count = 0;
		boolean isWord = false;
		boolean newWord = true;
		for (char c : input.toCharArray()) {
			if (isLetter(c) && (isWord || newWord)) {
				isWord = true;
				newWord = false;
			} else if (' ' == c && isWord) {
				count++;
				newWord = true;
				isWord = false;
			} else {
				isWord = false;
			}
		}
		if (isWord) {
			count++;
		}
		return count;
	}
	
	private boolean isWord(String block) {
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
