package hiring.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterRegexp implements WordCounter {

	@Override
	public int countWords(String inputText) {
		if (inputText == null) {
			throw new IllegalArgumentException("Input text cannot be null");
		}

		String pattern = "^[a-zA-Z]+$";
		Pattern r = Pattern.compile(pattern);

		int wordCount = 0;
		for (String textPart : inputText.split(" ")) {
			Matcher m = r.matcher(textPart);
			if (m.find()) {
				wordCount++;
			}
		}

		return wordCount;
	}

}
