package iterations.iteration.wordcount;

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
	public int countWords(String input) {
		return new TreeSet<String>(collectValidWords(input)).size();
	}
	
	@Override
	protected List<String> collectValidWords(String input) {
		if (other != null)
			return other.collectValidWords(input);
		return super.collectValidWords(input);
	}
	
}
