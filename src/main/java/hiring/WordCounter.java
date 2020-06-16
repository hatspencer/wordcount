package hiring;

public class WordCounter {

	public int countWords(String inputText) {
		int wordCount = 0;

		boolean wordFound = false;
		for (int charIndex = 0; charIndex < inputText.length(); charIndex++) {
			char character = inputText.charAt(charIndex);
			boolean isLetter = character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z';
			boolean isSpace = character >= ' ';
			if (isSpace) {
				if (wordFound) {
					wordCount++;
				}
				wordFound = false;
			} else if (isLetter) {
				wordFound = true;
			} else {
				wordFound = false;
			}
		}

		return wordCount;
	}

}
