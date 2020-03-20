package iterations.iteration.wordcount;

import java.util.ArrayList;
import java.util.List;

public class WordCountDecorator extends WordCount{
	
	private final WordCount other;

	public WordCountDecorator(WordCount other) {
		this.other = other;
	}
	public WordCountDecorator() {
		this(null);
	}
	
	@Override
	public List<String> collectValidWords(String input) {
		List<String> words = collectValidWordsInternal(input);
		List<String> finalWords = new ArrayList<String>(words.size());
		for (String word : words) {
			if (isValidWord(word)) {
				finalWords.add(word);
			}
		}
		return words;
	}
	
	private List<String> collectValidWordsInternal(String input) {
		if (other != null)
			return other.collectValidWords(input);
		return super.collectValidWords(input);
	}
	
}
