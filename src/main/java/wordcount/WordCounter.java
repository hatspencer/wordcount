package wordcount;

import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

	public int countWordsInAString(String text) {
		if (text.isEmpty()) {
			return 0;
		}
		return splitStringBySpace(text).length;
	}
	
	public String[] splitStringBySpace(String text) {
		return text.split(" ");
	}
	
	public List<String> filterValidString (List<String> stringList) {
		return stringList.stream()
				.filter(this::isValidCharacterString)
				.collect(Collectors.toList());
	}
	
	public boolean isValidCharacterString (String text) {
		return text.matches("[a-zA-Z]*");
	}
}
