package wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordCounterTest {

	private final WordCounter counter = new WordCounter();
	private final String NON_EMPTY_STRING = "This is Shubhi";
	private final int NON_EMPTY_STRING_WORD_COUNT = 3;
	private final String EMPTY_STRING = "";
	private final int EMPTY_STRING_WORD_COUNT = 0;
	private final String ALPHABETIC_STRING = "This";
	private final String NON_ALPHABETIC_STRING = "This 1One";
   
	@Test
	public void testCharactersOnlyString() {

	}

	@Test
	public void testCountWordsInAStringReturnsTotalNumberOfWordsWhenNonEmptyString() {
		int actualWordCount = counter.countWordsInAString(NON_EMPTY_STRING);

		assertTrue(NON_EMPTY_STRING_WORD_COUNT == actualWordCount);
	}

	@Test
	public void testCountWordsInAStringReturnsZeroWhenEmptyString() {
		int actualCount = counter.countWordsInAString(EMPTY_STRING);

		assertEquals(EMPTY_STRING_WORD_COUNT, actualCount);
	}
	
	@Test
	public void testIsValidCharacterStringReturnTrueWhenAlphabeticString () {
		assertTrue(counter.isValidCharacterString(ALPHABETIC_STRING));
	}
	
	@Test
	public void testIsValidCharacterStringReturnFalseWhenNonAlphabeticString () {
		assertFalse(counter.isValidCharacterString(NON_ALPHABETIC_STRING));
	}
	
	
}
