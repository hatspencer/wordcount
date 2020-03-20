package iterations.iteration.wordcount;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WordCountUnique extends WordCount{
	
	private final WordCount other;
	
	public WordCountUnique(WordCount other) {
		this.other = other;
	}
	
	public WordCountUnique() {
		this(null);
	}
	
	@Override
	public List<String> collectValidWords(String input) {
		return new ArrayList<String>(new TreeSet<String>(collectValidWordsInternal(input)));
	}
	
	private List<String> collectValidWordsInternal(String input) {
		if (other != null)
			return other.collectValidWords(input);
		return super.collectValidWords(input);
	}
	
}
