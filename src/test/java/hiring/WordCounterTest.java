package hiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WordCounterTest {

	private WordCounter wordCounter = new WordCounter();

	@Test
	public void GIVEN_one_word_WHEN_count_words_THEN_one_word() {
		// given
		String inputText = "word";
		int expectedNumberOfWords = 1;

		// when
		int wordCount = wordCounter.countWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, wordCount);
	}

	@Test
	public void GIVEN_two_words_WHEN_count_words_THEN_two_words() {
		// given
		String inputText = "word word";
		int expectedNumberOfWords = 2;

		// when
		int wordCount = wordCounter.countWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, wordCount);
	}

	@Test
	public void GIVEN_one_word_with_special_character_WHEN_count_words_THEN_special_word_not_counted() {
		// given
		String inputText = "word wor$d word";
		int expectedNumberOfWords = 2;

		// when
		int wordCount = wordCounter.countWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, wordCount);
	}

	@Test
	public void GIVEN_one_word_with_number_WHEN_count_words_THEN_special_word_not_counted() {
		// given
		String inputText = "word word3 word";
		int expectedNumberOfWords = 2;

		// when
		int wordCount = wordCounter.countWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, wordCount);
	}


}