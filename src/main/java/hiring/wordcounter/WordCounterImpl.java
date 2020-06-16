package hiring.wordcounter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounterImpl implements WordCounter {

	private WordFinder wordFinder;

	public WordCounterImpl() {
		this.wordFinder = new WordFinderImpl();
	}

	public WordCounterImpl(WordFinder wordFinder) {
		this.wordFinder = wordFinder;
	}

	@Override
	public WordCounterResult countWords(String inputText) {
		return countWords(inputText, Collections.emptySet());
	}

	@Override
	public WordCounterResult countWords(String inputText, Set<String> stopWords) {
		if (inputText == null) {
			throw new IllegalArgumentException("Input text cannot be null");
		}

		List<String> words = wordFinder.findWords(inputText);
		words = filterOutStopWords(words, stopWords);

		WordCounterResult result = new WordCounterResult();
		result.setNumberOfWords(words.size());
		result.setNumberOfUniqueWords(new HashSet<>(words).size());
		return result;
	}

	private List<String> filterOutStopWords(List<String> words, Set<String> stopWords) {
		List<String> wordsWithoutStopWords = words.stream()
				.filter(word -> !stopWords.contains(word))
				.collect(Collectors.toList());
		return wordsWithoutStopWords;
	}

}
