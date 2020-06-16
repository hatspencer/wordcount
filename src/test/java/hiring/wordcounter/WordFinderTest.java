package hiring.wordcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WordFinderTest {

	WordFinder wordFinder = new WordFinderImpl();

	@Test
	public void GIVEN_empty_string_WHEN_count_words_THEN_zero_words() {
		// given
		String inputText = "";
		int expectedNumberOfWords = 0;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_single_letter_word_WHEN_count_words_THEN_one_word() {
		// given
		String inputText = "w";
		int expectedNumberOfWords = 1;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_only_number_WHEN_count_words_THEN_zero_words() {
		// given
		String inputText = "234234 ";
		int expectedNumberOfWords = 0;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_one_word_WHEN_count_words_THEN_one_word() {
		// given
		String inputText = "word";
		int expectedNumberOfWords = 1;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_two_words_WHEN_count_words_THEN_two_words() {
		// given
		String inputText = "word word";
		int expectedNumberOfWords = 2;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_one_word_with_special_character_WHEN_count_words_THEN_special_word_not_counted() {
		// given
		String inputText = "word wor$d word";
		int expectedNumberOfWords = 2;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_one_word_with_number_WHEN_count_words_THEN_special_word_not_counted() {
		// given
		String inputText = "word word3 word";
		int expectedNumberOfWords = 2;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_multiple_spaces_between_words_WHEN_count_words_THEN_multiple_spaces_ignored() {
		// given
		String inputText = "    word                word          ";
		int expectedNumberOfWords = 2;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_just_comma_WHEN_count_words_THEN_zero_words() {
		// given
		String inputText = " , ";
		int expectedNumberOfWords = 0;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_word_with_hypen_WHEN_count_words_THEN_counted_as_one_word() {
		// given
		String inputText = "Humpty-Dumpty word";
		int expectedNumberOfWords = 2;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_word_with_hypen_at_the_end_WHEN_count_words_THEN_word_not_counted() {
		// given
		String inputText = "Humpty- word";
		int expectedNumberOfWords = 1;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

	@Test
	public void GIVEN_word_with_hypen_in_the_beginning_WHEN_count_words_THEN_word_not_counted() {
		// given
		String inputText = "-Humpty word";
		int expectedNumberOfWords = 1;

		// when
		List<String> foundWords = wordFinder.findWords(inputText);

		// then
		assertEquals(expectedNumberOfWords, foundWords.size());
	}

}