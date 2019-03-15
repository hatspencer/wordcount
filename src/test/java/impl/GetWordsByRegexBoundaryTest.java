package impl;

import impl.GetWordsByRegexBoundary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetWordsByRegexBoundaryTest {

	private static final String EMPTY_STRING = "";

	@Test
	void getWordsFromEmptyStringReturnsEmptyCollection() {
		GetWordsByRegexBoundary getWordsByRegexBoundary = new GetWordsByRegexBoundary();

		Collection<String> words = getWordsByRegexBoundary.getWords(EMPTY_STRING);

		assertEquals(0, words.size());
	}

	@Test
	void getWordsFromNullStringReturnsEmptyCollection() {
		GetWordsByRegexBoundary getWordsByRegexBoundary = new GetWordsByRegexBoundary();

		Collection<String> words = getWordsByRegexBoundary.getWords(null);

		assertEquals(0, words.size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"one two", "one3two", "one?two"})
	void getWordsFromTwoWordsStringReturnsCollectionWithTwoItems(String twoWordsString) {
		GetWordsByRegexBoundary getWordsByRegexBoundary = new GetWordsByRegexBoundary();

		Collection<String> words = getWordsByRegexBoundary.getWords(twoWordsString);

		assertEquals(2, words.size());
	}
}