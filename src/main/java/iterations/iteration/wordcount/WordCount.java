package iterations.iteration.wordcount;

public class WordCount {

	public int countWords(String input) {
		if (input == null)
			return 0;
		String[] inputWords = input.split("[ ,\\t]+");
		int count = 0;
		for (int i = 0; i < inputWords.length; i++) {
			if (isValidWord(inputWords[i])) {
				count++;
			}
		}
		return count;
	}
	
	private boolean isValidWord(String word) {
		return word.matches("[a-zA-Z]+");
	}
	
}
