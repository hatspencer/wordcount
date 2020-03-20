package iterations.iteration.wordcount.cmd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import iterations.iteration.wordcount.WordCount;
import iterations.iteration.wordcount.WordCountUnique;

public class WordCountMainTest {

	@Test
	public void createWordCountTest() {
		WordCountMain wcm = new WordCountMain();
		WordCount wc = wcm.createWordCount();
		
		assertEquals(wc.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 9);
		
		WordCountUnique wcu = new WordCountUnique(wc);
		assertEquals(wcu.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 7);
	}
	
}
