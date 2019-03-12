package wordcount;

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
	
	public boolean isValidCharacterString (String text) {
		return text.matches("a-zA-Z");
	}
}
