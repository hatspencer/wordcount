package wordcount;

public class WordCounter {

	public int countWords(String input) {
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
	
	private static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
}
