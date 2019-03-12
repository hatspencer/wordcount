package wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
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
	private final String NOT_A_STOPWORD = "hello";
	private final String STOPWORD = "the";
	private final List<String> WORDLIST_WITH_STOPWORDS =  Arrays.asList(STOPWORD, NOT_A_STOPWORD);
	private final List<String> FILTERD_WORDLIST =  Arrays.asList(NOT_A_STOPWORD);
	private final List<String> STOPWORDS_LIST =  Arrays.asList(STOPWORD);
	private final String TEXT_WITH_A_STOPWORD =  STOPWORD + " " + NOT_A_STOPWORD;
	private final int TEXT_WITH_A_STOPWORD_VALID_COUNT =  1;
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
	public void testCountWordsInAStringReturnsFilteredWordCountWithStopList() {
         int actualCount = counter.countWordsInAString(TEXT_WITH_A_STOPWORD, STOPWORDS_LIST);
         
         assertEquals(TEXT_WITH_A_STOPWORD_VALID_COUNT, actualCount);
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
	
	@Test
	public void testIsNotAStopWordReturnsTrueWhenNotAStopWord() {
		assertTrue(counter.isNotAStopWord(NOT_A_STOPWORD, STOPWORDS_LIST));
	}
	
	@Test
	public void testIsNotAStopWordReturnsFalseWhenIsAStopWord() {
		assertFalse(counter.isNotAStopWord(STOPWORD, STOPWORDS_LIST));
	}
	
	@Test
	public void testIsNotAStopWordReturnsTrueWhenStopwordListIsEmpty() {
		assertTrue(counter.isNotAStopWord(NOT_A_STOPWORD, Collections.emptyList()));
	}
	
	@Test
	public void testFilterStopWordsReturnsFilteredList() {
		List<String> actualFilteredList = counter.filterStopWords(WORDLIST_WITH_STOPWORDS, STOPWORDS_LIST);
		assertEquals(FILTERD_WORDLIST, actualFilteredList);
	}
	

}
