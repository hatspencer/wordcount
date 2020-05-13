package wordcount;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import wordcount.service.WordCountService;
import wordcount.service.WordExclusionComponent;

public class WordCountServiceTest {

	@Test
	public void testWordCountService() {
		String[] data = new String[] {"a", "a b", " a   b  ", "a. b", "a.b c", " a.b.c ", " a.b.c  d ", "", null};
		long[] results = new long[] {1, 2, 2, 1, 1, 0, 1, 0, 0} ;
		for (int i = 0; i < data.length; i++) {
			String input = data[i];
			long expectedResult = results[i];
			long actualResult = WordCountService.getWordCount(input);
			Assert.assertEquals(expectedResult, actualResult);
		}
	}
	
	@Test
	public void testWordCountServiceWithExclusionWordComponent() {
		WordExclusionComponent component = new WordExclusionComponent(Arrays.asList("b"));
		String[] data = new String[] {"a", "a b", " a   b  ", "a. b", "a.b c", " a.b.c ", " a.b.c  d ", "", null};
		long[] results = new long[] {  1,      1,           1,     0,       1,         0,            1,  0,    0} ;
		for (int i = 0; i < data.length; i++) {
			String input = data[i];
			long expectedResult = results[i];
			long actualResult = WordCountService.getWordCount(input, component);
			Assert.assertEquals(expectedResult, actualResult);
		}
	}
	
}
