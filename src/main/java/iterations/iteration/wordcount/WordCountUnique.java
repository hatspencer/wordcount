package iterations.iteration.wordcount;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WordCountUnique extends WordCountDecorator{
	
	public WordCountUnique(WordCount other) {
		super(other);
	}
	
	public WordCountUnique() {
		super();
	}
	
	@Override
	public List<String> collectValidWords(String input) {
		return new ArrayList<String>(new TreeSet<String>(super.collectValidWords(input)));
	}
	
}
