package hiring.wordcounter;

public class WordCounterParser implements WordCounter {

	@Override
	public int countWords(String inputText) {
		if (inputText == null) {
			throw new IllegalArgumentException("Input text cannot be null");
		}

		int wordCount = 0;

		boolean wordFound = false;
		for (int charIndex = 0; charIndex < inputText.length(); charIndex++) {
			char character = inputText.charAt(charIndex);
			boolean isLetter = character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z';
			boolean isSpace = character == ' ';
			if (isSpace) {
				if (wordFound) {
					wordCount++;
				}
				wordFound = false;
			} else if (isLetter) {
				wordFound = true;
			} else {
				wordFound = false;
				while (inputText.charAt(charIndex) != ' ' && charIndex < inputText.length()) {
					charIndex++;
				}
			}
		}

		if (wordFound) {
			wordCount++;
		}

		return wordCount;
	}

}
