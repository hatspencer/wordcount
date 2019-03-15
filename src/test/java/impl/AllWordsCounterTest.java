package impl;

import api.WordFilter;
import api.WordsProvider;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AllWordsCounterTest {

	@Test
	void countReturnsTwoWhenWordProviderProvidesTwoWordsWithNoWordFilter() {
		AllWordsCounter allWordsCounter = new AllWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));

		int wordCount = allWordsCounter.count("", wordsProviderMock, null);

		assertEquals(2, wordCount);
	}

	@Test
	void countReturnsZeroWhenInputIsNull() {
		AllWordsCounter allWordsCounter = new AllWordsCounter();

		int wordCount = allWordsCounter.count(null, null, null);

		assertEquals(0, wordCount);
	}

	@Test
	void countReturnsZeroWhenFilterAcceptsNoWords() {
		AllWordsCounter allWordsCounter = new AllWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));
		WordFilter wordsFilterMock = mock(WordFilter.class);
		when(wordsFilterMock.accept(any())).thenReturn(false);

		int wordCount = allWordsCounter.count("", wordsProviderMock, wordsFilterMock);

		assertEquals(0, wordCount);
	}

	@Test
	void countReturnsTwoWhenFilterAcceptsAllWords() {
		AllWordsCounter allWordsCounter = new AllWordsCounter();
		WordsProvider wordsProviderMock = mock(WordsProvider.class);
		when(wordsProviderMock.getWords(any())).thenReturn(Arrays.asList("one", "two"));
		WordFilter wordsFilterMock = mock(WordFilter.class);
		when(wordsFilterMock.accept(any())).thenReturn(true);

		int wordCount = allWordsCounter.count("", wordsProviderMock, wordsFilterMock);

		assertEquals(2, wordCount);
	}
}