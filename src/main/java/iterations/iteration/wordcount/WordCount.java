package iterations.iteration.wordcount;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordCount {
	
	public final static String EMPTY_CHARS_REGEX = "[ ,\\t]+";

	public static final String VALID_WORD_DEFAULT_EXPRESSION = "[a-zA-Z]+";
	
	final Set<String> stopWords = new HashSet<String>();
	
	private String validWordExp = VALID_WORD_DEFAULT_EXPRESSION;
	
	private String wordsSeparator = EMPTY_CHARS_REGEX;

	public int countWords(String input) {
		return collectValidWords(input).size();
	}
	
	protected List<String> collectValidWords(String input) {
		if (input == null)
			return Collections.emptyList();
		String[] inputWords = input.split(wordsSeparator);
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
		return word.matches(validWordExp) && !stopWords.contains(word);
	}

	public void setValidWordExp(String validWordExp) {
		this.validWordExp = validWordExp;
	}

	public void setWordsSeparator(String wordsSeparator) {
		this.wordsSeparator = wordsSeparator;
	}
	
}
