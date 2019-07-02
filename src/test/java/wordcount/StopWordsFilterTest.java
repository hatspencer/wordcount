package wordcount;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class StopWordsFilterTest {
	
	private static final Collection<String> STOP_WORDS = Arrays.asList("a", "b");
	
	@Test
	public void testStopWordsFilter() {
		StopWordsFilter stopWordsFilter = new StopWordsFilter(STOP_WORDS);
		
		Assert.assertTrue(stopWordsFilter.test("c"));
		Assert.assertFalse(stopWordsFilter.test("a"));
	}
}
