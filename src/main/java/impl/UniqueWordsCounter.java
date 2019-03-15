package impl;

import api.WordCounter;
import api.WordFilter;
import api.WordsProvider;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordsCounter implements WordCounter {

	@Override
	public int count(String input, WordsProvider wordsProvider, WordFilter wordFilter) {
		if (input == null) {
			return 0;
		}

		Set<String> words = new HashSet<>();
		int count = 0;
		for (String word : wordsProvider.getWords(input)) {
			if (words.add(word) && (wordFilter == null || wordFilter.accept(word))) {
				count++;
			}
		}

		return count;
	}
}
