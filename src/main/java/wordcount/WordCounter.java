package wordcount;

public class WordCounter {

	public int countWordsInAString(String userString) {
		if (userString.isEmpty()) {
			return 0;
		}
		return userString.split(" ").length;
	}
}
