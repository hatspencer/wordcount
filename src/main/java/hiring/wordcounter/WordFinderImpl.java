package hiring.wordcounter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinderImpl implements WordFinder {

	@Override
	public List<String> findWords(String inputText) {
		String pattern = "^[a-zA-Z]+$";
		Pattern r = Pattern.compile(pattern);

		inputText = inputText.replace("\n", " ");

		List<String> foundWords = new ArrayList<>();
		for (String textPart : inputText.split(" ")) {
			Matcher m = r.matcher(textPart);
			if (m.find()) {
				String word = m.group();
				foundWords.add(word);
			}
		}

		return foundWords;
	}
}
