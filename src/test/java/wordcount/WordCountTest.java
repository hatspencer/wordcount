package wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WordCountTest {

	private final StopWordsFilter stopWordsFilter = new StopWordsFilter(Arrays.asList("a", "the"));
	
	@Test
	public void testWordCounterSingleString() {
		WordCounter wordCounter = new WordCounter(x -> true);
		
		Assert.assertEquals(1, wordCounter.countWordsOf("a"));
		Assert.assertEquals(0, wordCounter.countWordsOf("a1"));
		Assert.assertEquals(2, wordCounter.countWordsOf("a a"));
		Assert.assertEquals(2, wordCounter.countWordsOf("abc	abc"));
		Assert.assertEquals(1, wordCounter.countWordsOf(" abc	 a@bc"));
	}
	
	@Test
	public void testWordCounterSingleStringWithFilter() {
		
		WordCounter wordCounter = new WordCounter(stopWordsFilter);
		
		Assert.assertEquals(0, wordCounter.countWordsOf("a"));
		Assert.assertEquals(1, wordCounter.countWordsOf("a the abc"));
		Assert.assertEquals(2, wordCounter.countWordsOf("abc	abc"));
	}
	
	@Test
	public void testWordCounterStringEmptyCollection() {
		WordCounter wordCounter = new WordCounter(x -> true);
		
		Assert.assertEquals(0, wordCounter.countWordsOf(Collections.emptyList()));
		
	}
	
	@Test
	public void testWordCounterStringCollection() {
		WordCounter wordCounter = new WordCounter(x -> true);
		
		List<String> text = Arrays.asList("", "a", "abc ab1c a@bc");
		Assert.assertEquals(2, wordCounter.countWordsOf(text));
	}
	
	@Test
	public void testWordCounterStringCollectionWithFilter() {
		WordCounter wordCounter = new WordCounter(stopWordsFilter);
		
		List<String> text = Arrays.asList("", "a", "abc ab1c a@bc");
		Assert.assertEquals(1, wordCounter.countWordsOf(text));
	}
}
