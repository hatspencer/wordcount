package hiring.wordcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WordCounterTest {

	private WordCounter wordCounter = new WordCounterImpl();

	@Test(expected = IllegalArgumentException.class)
	public void GIVEN_null_string_WHEN_count_words_THEN_illegal_argument_exception_expected() {
		// given
		String inputText = null;

		// when
		wordCounter.countWords(inputText);

		// then exception
	}

	@Test
	public void GIVEN_two_unique_words_WHEN_count_words_THEN_correct_number_of_words() {
		// given
		List<String> mockedFoundWords = Arrays.asList("word1", "word2");
		int expectedNumberOfWords = 2;

		// when
		wordCounter = new WordCounterImpl(createMockWordFinder(mockedFoundWords), createMockWorkdLenghtCounter());
		WordCounterResult wordCounterResult = wordCounter.countWords("ignored_input");

		// then
		assertEquals(expectedNumberOfWords, wordCounterResult.getNumberOfWords());
		assertEquals(expectedNumberOfWords, wordCounterResult.getNumberOfUniqueWords());
	}

	@Test
	public void GIVEN_non_unique_words_WHEN_count_words_THEN_correct_number_of_words() {
		// given
		List<String> mockedFoundWords = Arrays.asList("word1", "word2", "word1", "word1");
		int expectedNumberOfWords = 4;
		int expectedUniqueNumberOfWords = 2;

		// when
		wordCounter = new WordCounterImpl(createMockWordFinder(mockedFoundWords), createMockWorkdLenghtCounter());
		WordCounterResult wordCounterResult = wordCounter.countWords("ignored_input");

		// then
		assertEquals(expectedNumberOfWords, wordCounterResult.getNumberOfWords());
		assertEquals(expectedUniqueNumberOfWords, wordCounterResult.getNumberOfUniqueWords());
	}

	private WordFinder createMockWordFinder(List<String> mockedFoundWords) {
		return inputText -> mockedFoundWords;
	}

	private WordLengthCounter createMockWorkdLenghtCounter() {
		return words -> 0;
	}
}