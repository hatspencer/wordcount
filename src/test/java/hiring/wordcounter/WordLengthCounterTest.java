package hiring.wordcounter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class WordLengthCounterTest {

	WordLengthCounter wordLengthCounter = new WordLengthCounterImpl();

	@Test
	public void GIVEN_one_letter_word_WHEN_count_average_word_lwngth_THEN_correct_value() {
		// given
		List<String> mockedWords = Arrays.asList("a");
		double expectedAverageWordLength = 1D;

		// when
		double averageWordLength = wordLengthCounter.countAverageWordLength(mockedWords);

		// then
		assertEquals(expectedAverageWordLength, averageWordLength, 0.1);
	}

	@Test
	public void GIVEN_multipe_words_WHEN_count_average_word_lwngth_THEN_correct_value() {
		// given
		List<String> mockedWords = Arrays.asList("aaa", "bbbbbb", "ccc");
		double expectedAverageWordLength = 4D;

		// when
		double averageWordLength = wordLengthCounter.countAverageWordLength(mockedWords);

		// then
		assertEquals(expectedAverageWordLength, averageWordLength, 0.1);
	}
}