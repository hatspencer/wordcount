package wordcount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import wordcount.service.WordCountService;

public class WordCountServiceTest {

	@Test
	public void testGetStreamInputLine() {
		String inputLine = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
		Stream<String> stream = WordCountService.getStream(inputLine);
		long count = stream.count();
		Assert.assertEquals(12L, count);
	}
	
	@Test
	public void testWordCountService() {
		String[] data = new String[] {"a", "a b", " a   b  ", "a. b", "a.b c", " a.b.c ", " a.b.c  d ", "", null};
		long[] results = new long[] {1, 2, 2, 2, 1, 0, 1, 0, 0} ;
		for (int i = 0; i < data.length; i++) {
			String input = data[i];
			long expectedResult = results[i];
			long actualResult = WordCountService.getResult((input)).getWordCount();
			Assert.assertEquals(expectedResult, actualResult);
		}
	}
	
	@Test
	public void testWordCountServiceWithExclusionWordComponent() {
		String[] data = new String[] {"a", "a b", " a   b  ", "a. b", "a.b c", " a.b.c ", " a.b.c  d ", "", null};
		long[] results = new long[] {  0,      0,           0,     0,       1,         0,            1,  0,    0} ;
		for (int i = 0; i < data.length; i++) {
			String input = data[i];
			long expectedResult = results[i];
			long actualResult = WordCountService.getResult(input, new HashSet<>(Arrays.asList(new String[] {"a", "b"}))).getWordCount();
			Assert.assertEquals(expectedResult, actualResult);
		}
	}
	
}
