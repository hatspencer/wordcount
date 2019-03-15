package impl;

import api.WordCounter;
import api.WordFilter;
import api.WordsProvider;

public class AllWordsCounter implements WordCounter {

	@Override
	public int count(String input, WordsProvider wordsProvider, WordFilter wordFilter) {
		if (input == null) {
			return 0;
		}

		int count = 0;
		for (String word : wordsProvider.getWords(input)) {
			if (wordFilter == null || wordFilter.accept(word)) {
				count++;
			}
		}

		return count;
	}
}