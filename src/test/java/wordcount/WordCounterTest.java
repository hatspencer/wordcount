package wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testCountWordsInAString () {
		WordCounter counter = new WordCounter();
	    int expectedCount = 0;
	    int actualCount = counter.countWordsInAString("");
	    assertEquals(expectedCount, actualCount);
	}
}
