package wordcount;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class StartTest {
	
	@Test
	public void countWordsReturnsOnlyCountableWords() {
		final String countableWord = "word"; // to be counted
		final String notOnlyLettersWord = "word2"; // not to be counted
		final String stopWord = "a"; // not to be counted
		Assert.assertEquals(1, Start.countWords(Arrays.asList(countableWord, notOnlyLettersWord, stopWord)));
	}
}
