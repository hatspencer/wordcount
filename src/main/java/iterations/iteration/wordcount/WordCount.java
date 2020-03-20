package iterations.iteration.wordcount;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordCount {
	
	final Set<String> stopWords = new HashSet<String>();

	public int countWords(String input) {
		return collectValidWords(input).size();
	}
	
	protected List<String> collectValidWords(String input) {
		if (input == null)
			return Collections.emptyList();
		String[] inputWords = input.split("[ ,\\t]+");
		List<String> validWords = new LinkedList<String>();
		for (int i = 0; i < inputWords.length; i++) {
			if (isValidWord(inputWords[i])) {
				validWords.add(inputWords[i]);
			}
		}
		return validWords;
	}
	
	public void addStopWords(String... stopWords) {
		addStopWords(Arrays.asList(stopWords));
	}
	
	public void addStopWords(Collection<String> stopWords) {
		if (stopWords != null) {
			for (String stopWord : stopWords) {
				if (isValidWord(stopWord)) {
					this.stopWords.add(stopWord);
				}
			}
		}
	}
	
	private boolean isValidWord(String word) {
		return word.matches("[a-zA-Z]+") && !stopWords.contains(word);
	}
	
}
