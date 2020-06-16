package hiring.wordcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SimpleStopWordsParserTest {

	private StopWordsParser stopWordsParser = new SimpleStopWordsParser();

	@Test
	public void GIVEN_two_stop_words_separated_by_newline_WHEN_load_stop_words_THEN_correct_count() {
		// given
		String stopWordsInput = "word1\nword2";
		int expectedStopWordsCount = 2;

		// when
		Set<String> stopWords = stopWordsParser.parseStopWords(stopWordsInput);

		// then
		assertEquals(expectedStopWordsCount, stopWords.size());
	}

	@Test
	public void GIVEN_empty_string_WHEN_load_stop_words_THEN_no_words() {
		// given
		String stopWordsInput = "    \n    ";
		int expectedStopWordsCount = 0;

		// when
		Set<String> stopWords = stopWordsParser.parseStopWords(stopWordsInput);

		// then
		assertEquals(expectedStopWordsCount, stopWords.size());
	}

}