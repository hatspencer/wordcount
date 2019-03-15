package impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RegexCounterTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "    "})
	void testEmptyString(String empty) {
		AllWordsCounter allWordsCounter = new AllWordsCounter();
		GetWordsByRegexBoundary getWordsByRegexBoundary = new GetWordsByRegexBoundary();

		assertEquals(0, allWordsCounter.count(empty, getWordsByRegexBoundary, null));
	}

	@Test
	void testNull() {
		assertEquals(0, new AllWordsCounter().count(null, new GetWordsByRegexBoundary(), null));
	}

	@ParameterizedTest
	@MethodSource("wordCountAndInputProvider")
	void testWordBoundary(int wordCount, String input) {
		assertEquals(wordCount, new AllWordsCounter().count(input, new GetWordsByRegexBoundary(), null));
	}

	static Stream<Arguments> wordCountAndInputProvider() {
		return Stream.of(
				arguments(2, "one two"),
				arguments(2, "one.two"),
				arguments(2, "one?two")
		);
	}
}