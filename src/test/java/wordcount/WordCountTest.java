package wordcount;

import org.junit.Assert;
import org.junit.Test;

public class WordCountTest {

	@Test
	public void testWordCounter() {
		WordCounter wordCounter = new WordCounter();
		
		Assert.assertEquals(1, wordCounter.countWordsOf("a"));
		Assert.assertEquals(0, wordCounter.countWordsOf("a1"));
		Assert.assertEquals(2, wordCounter.countWordsOf("a a"));
		Assert.assertEquals(2, wordCounter.countWordsOf("abc	abc"));
		Assert.assertEquals(1, wordCounter.countWordsOf(" abc	 a@bc"));
	}
}
