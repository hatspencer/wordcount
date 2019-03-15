package impl;

import api.WordFilter;
import api.WordsProvider;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UniqueWordsCounterTest {

	@Test
	void countReturnsTwoWhenWordProviderProvidesTwoUniqueWordsWithNoWordFilter() {
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));

		int wordCount = uniqueWordsCounter.count("", wordsProviderMock, null);

		assertEquals(2, wordCount);
	}

	@Test
	void countReturnsTwoWhenWordProviderProvidesThreeWordsWhereTwoWordsAreUniqueWithNoWordFilter() {
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two", "two"));

		int wordCount = uniqueWordsCounter.count("", wordsProviderMock, null);

		assertEquals(2, wordCount);
	}

	@Test
	void countReturnsZeroWhenInputIsNull() {
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();

		int wordCount = uniqueWordsCounter.count(null, null, null);

		assertEquals(0, wordCount);
	}

	@Test
	void countReturnsZeroWhenFilterAcceptsNoWords() {
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));
		WordFilter wordsFilterMock = mock(WordFilter.class);
		when(wordsFilterMock.accept(any())).thenReturn(false);

		int wordCount = uniqueWordsCounter.count("", wordsProviderMock, wordsFilterMock);

		assertEquals(0, wordCount);
	}

	@Test
	void countReturnsTwoWhenFilterAcceptsAllWordsAndWordProviderProvidesTwoUniqueWords() {
		UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));
		WordFilter wordsFilterMock = mock(WordFilter.class);
		when(wordsFilterMock.accept(any())).thenReturn(true);

		int wordCount = uniqueWordsCounter.count("", wordsProviderMock, wordsFilterMock);

		assertEquals(2, wordCount);
	}
}