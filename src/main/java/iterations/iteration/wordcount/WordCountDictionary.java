package iterations.iteration.wordcount;

import java.util.Set;

public class WordCountDictionary extends WordCountDecorator {
	
	Set<String> dictionary;
	
	public WordCountDictionary(Set<String> dictionary, WordCount other) {
		super(other);
		this.dictionary = dictionary;
	}
	
	@Override
	public boolean isValidWord(String word) {
		return dictionary.contains(word);
	}
}
