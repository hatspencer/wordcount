package hiring.wordcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WordCounterWithStopWordsTest {

	private WordCounter wordCounter = new WordCounterImpl();

	@Test
	public void GIVEN_some_stop_word_that_are_in_input_text_WHEN_count_words_THEN_stop_words_not_counted() {
		// given
		Set<String> stopWords = new HashSet<>(Arrays.asList("best", "all", "not_in_input"));
		String inputText = "the best of all";
		int expectedNumberOfWords = 2;

		// when
		WordCounterResult wordCounterResult = wordCounter.countWords(inputText, stopWords);

		// then
		assertEquals(expectedNumberOfWords,wordCounterResult.getNumberOfWords());
	}

	@Test
	public void GIVEN_empty_stop_word_WHEN_count_words_THEN_all_words_counted() {
		// given
		Set<String> stopWords = new HashSet<>();
		String inputText = "the best of all";
		int expectedNumberOfWords = 4;

		// when
		WordCounterResult wordCounterResult = wordCounter.countWords(inputText, stopWords);

		// then
		assertEquals(expectedNumberOfWords, wordCounterResult.getNumberOfWords());
	}

}