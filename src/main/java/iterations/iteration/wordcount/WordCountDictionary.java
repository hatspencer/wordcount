package iterations.iteration.wordcount;

import java.util.Set;

public class WordCountDictionary extends WordCount {
	
	Set<String> dictionary;
	
	public WordCountDictionary(Set<String> dictionary) {
		this.dictionary = dictionary;
	}
	
	@Override
	protected boolean isValidWord(String word) {
		return dictionary.contains(word);
	}
}
