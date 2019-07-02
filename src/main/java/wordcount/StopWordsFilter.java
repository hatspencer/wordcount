package wordcount;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

public class StopWordsFilter implements Predicate<String> {
	private final Collection<String> stopWords;

	public StopWordsFilter(Collection<String> stopWords) {
		this.stopWords = Collections.unmodifiableCollection(stopWords);
	}

	@Override
	public boolean test(String word) {
		return !stopWords.contains(word);
	}
	
	
}
