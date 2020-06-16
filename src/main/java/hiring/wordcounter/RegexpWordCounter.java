package hiring.wordcounter;

import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpWordCounter implements WordCounter {

	@Override
	public int countWords(String inputText) {
		return countWords(inputText, Collections.emptySet());
	}

	@Override
	public int countWords(String inputText, Set<String> stopWords) {
		if (inputText == null) {
			throw new IllegalArgumentException("Input text cannot be null");
		}

		String pattern = "^[a-zA-Z]+$";
		Pattern r = Pattern.compile(pattern);

		int wordCount = 0;
		for (String textPart : inputText.split(" ")) {
			Matcher m = r.matcher(textPart);
			if (m.find()) {
				String word = m.group();
				if (!isStopWord(word, stopWords)) {
					wordCount++;
				}
			}
		}

		return wordCount;
	}

	private boolean isStopWord(String word, Set<String> stopWords) {
		return stopWords != null && stopWords.contains(word);
	}
}
