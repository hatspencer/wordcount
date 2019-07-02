package wordcount;

import org.junit.Assert;
import org.junit.Test;

public class StartTest {
	
	@Test
	public void countWordsReturns2() {
		Assert.assertEquals(1, Start.countWords("word word2 a the"));
	}
}
