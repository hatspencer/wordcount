package wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

	public int countWordsInAString(String text) {
		return countWordsInAString(text, Collections.emptyList());
	}
	
	public int countWordsInAString(String text, List<String> stopWords) {
		if (text.isEmpty()) {
			return 0;
		}
		List<String> stringWithoutNonAlphabeticWords = filterValidString(Arrays.asList(splitStringBySpace(text)));
		return filterStopWords(stringWithoutNonAlphabeticWords, stopWords).size();
	}
	
	public String[] splitStringBySpace(String text) {
		return text.split(" ");
	}
	
	public List<String> filterValidString (List<String> stringList) {
		return stringList.stream()
				.filter(this::isValidCharacterString)
				.collect(Collectors.toList());
	}
	
	public List<String> filterStopWords (List<String> stringList, List<String> stopWords) {
		return stringList.stream()
				.filter(s -> isNotAStopWord(s, stopWords))
				.collect(Collectors.toList());
	}

	public boolean isValidCharacterString (String text) {
		return text.matches("[a-zA-Z]*");
	}
	
	public boolean isNotAStopWord (String text, List<String> stopWords) {
		return stopWords.stream().noneMatch(text::equals);
	}
}
