package wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordCounterTest {

	private final WordCounter counter = new WordCounter();
	private final String NON_EMPTY_STRING = "This is Shubhi";
	private final int NON_EMPTY_STRING_WORD_COUNT = 3;
	private final String EMPTY_STRING = "";
	private final int EMPTY_STRING_WORD_COUNT = 0;
	private final String ALPHABETIC_STRING = "This";
	private final String NON_ALPHABETIC_STRING = "This 1One";
	private final List<String> LIST_OF_STRINGS = Arrays.asList("one","two","3");
	private final List<String> LIST_OF_VALID_STRINGS = Arrays.asList("one","two");
	private final String STRING_WITH_NON_ALPHABETIC_WORDS = "One 2 Three";
	private final int STRING_WITH_NON_ALPHABETIC_WORDS_VALID_COUNT = 2;
	private final String STRING_WITH_WHITESPACE = "  ";
	private final int STRING_WITH_WHITESPACE_COUNT = 0;
	private final String STRING_WITH_ONLY_NON_ALPHABETIC_WORDS = "1 2 3";
	private final int STRING_WITH_ONLY_NON_ALPHABETIC_WORDS_VALID_COUNT = 0;
		
	@Test
	public void testCountWordsInAStringReturnsZeroWhenEmptyString() {
		int actualCount = counter.countWordsInAString(EMPTY_STRING);

		assertEquals(EMPTY_STRING_WORD_COUNT, actualCount);
	}
	
	@Test
	public void testCountWordsInAStringReturnsZeroWhenWhiteSpaceString() {
		int actualCount = counter.countWordsInAString(STRING_WITH_WHITESPACE);

		assertEquals(STRING_WITH_WHITESPACE_COUNT, actualCount);
	}
	
	@Test
	public void testCountWordsInAStringReturnsZeroWhenNonAlphabetOnlyString() {
		int actualCount = counter.countWordsInAString(STRING_WITH_ONLY_NON_ALPHABETIC_WORDS);

		assertEquals(STRING_WITH_ONLY_NON_ALPHABETIC_WORDS_VALID_COUNT, actualCount);
	}
	
	@Test
	public void testCountWordsInAStringReturnsTotalNumberOfWordsWhenNonEmptyString() {
		int actualWordCount = counter.countWordsInAString(NON_EMPTY_STRING);

		assertTrue(NON_EMPTY_STRING_WORD_COUNT == actualWordCount);
	}
	
	@Test
	public void testCountWordsInAStringReturnsTotalNumberOfAlphabeticWordsWhenStringWithNonAlphabeticWords() {
         int actualCount = counter.countWordsInAString(STRING_WITH_NON_ALPHABETIC_WORDS);
         
         assertEquals(STRING_WITH_NON_ALPHABETIC_WORDS_VALID_COUNT, actualCount);
	}
		
	@Test
	public void testIsValidCharacterStringReturnTrueWhenAlphabeticString () {
		assertTrue(counter.isValidCharacterString(ALPHABETIC_STRING));
	}
	
	@Test
	public void testIsValidCharacterStringReturnFalseWhenNonAlphabeticString () {
		assertFalse(counter.isValidCharacterString(NON_ALPHABETIC_STRING));
	}
	
	@Test
	public void testFilterValidStringReturnCountOFAlphabeticWords () {
		 List<String> filteredListOfStrings = counter.filterValidString(LIST_OF_STRINGS);
		 
		 assertEquals(LIST_OF_VALID_STRINGS, filteredListOfStrings);
	}
	
}
