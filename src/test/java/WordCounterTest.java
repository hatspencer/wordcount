import static org.junit.Assert.assertEquals;

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
	
	
	private int getCountOfWords(String message) {
		WordCounter counter = new WordCounter(message);
		return counter.wordsCount();
	}
}
	
	
	
	
