import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class WordCounterTest {
				
	@Test
	public void shouldReturnWordCount() {
		
		String message = "Hello world";
		int count = getCountOfWords(message);
		
		assertEquals(2, count);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionCountIfInputIsNull() {
		
		String message = null;
		int count = getCountOfWords(message);		
	}
	
	@Test
	public void shouldReturnZeroCountIfInputIsEmpty() {
		
		String message = "";
		int count = getCountOfWords(message);
		
		assertEquals(0, count);
	}
	
	@Test
	public void shouldReturnZeroIfWordIcludesNumbers() {
		
		String message = "Hello123";		
		int count = getCountOfWords(message);
		
		assertEquals(0, count);		
	}
	
	@Test
	public void shouldReturnOneIfFirstOfTwoWordsIsNotValid() {
		String message = "Hello123 abc";
		int count = getCountOfWords(message);
		
		assertEquals(1, count);		
		
	}
	
	@Test
	public void shouldReturnOneIfSecondOfTwoWordsIsNotValid() {
		String message = "abc 1234";
		int count = getCountOfWords(message);
		
		assertEquals(1, count);	
	}
	
	@Test
	public void shouldReturnZeroIfSpecialCharactersAndNumbersIcluded() {
		
		String message = "abc*/* 1234";
		int count = getCountOfWords(message);
		
		assertEquals(0, count);	
		
	}
	
	@Test
	public void shouldReturnTwoIfSpacesAreIncludedAndTrimNotAppliedToString() {
		
		String message = "   abc   1234   exrT   ";
		int count = getCountOfWords(message);
		
		assertEquals(2, count);	
		
	}
	
	@Test 
	public void shouldExcludeTheWordsFromTheBlacklist() {
		
		String[] excluded = new String[] { "one", "two" };
		List<String> excludedWords = Arrays.asList(excluded);
		
		String message = "one abc";
		WordCounter counter = getWordCounter(message);
		counter.setExcludedWords(excludedWords);
				
		int count = counter.wordsCount();		
		assertEquals(1, count);			
	}
	
	@Test
	public void shouldReturnTheUniqueWordsCount()
	{
		String[] excluded = new String[0]; // { "the", "a", "on", "off" };
		final String message = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
		WordCounter counter = new WordCounter(message, Arrays.asList(excluded));
		int count = counter.wordsCount();
		int result = counter.getUniqueWordsCount();
		
		//assertEquals(9, count);
		assertEquals(7, result);
	}
	
	private int getCountOfWords(String message) {
		WordCounter counter = getWordCounter(message);
		return counter.wordsCount();
	}
	
	private WordCounter getWordCounter(String message) 
	{
		return new WordCounter(message, new ArrayList<String>());
	}	
}
	
	
	
	
