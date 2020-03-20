package iterations.iteration.wordcount.cmd;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import iterations.iteration.wordcount.WordCount;
import iterations.iteration.wordcount.WordCountUnique;

public class WordCountMainTest {

	@Test
	public void createWordCountTest() {
		WordCountMain wcm = new WordCountMain();
		WordCount wc = wcm.createWordCount();
		
		assertEquals(wc.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 7);
		
		WordCountUnique wcu = new WordCountUnique(wc);
		assertEquals(wcu.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), 6);
		
		assertEquals(wcu.countWords("Humpty-Dumpty -sat on a wall. Humpty-Dumpty- had a great fall."), 7);
	}

	@Test
	public void getIndex() {
		
		WordCountMain wcm = new WordCountMain();
		
		// expect: -sat fall great had Humpty-Dumpty Humpty-Dumpty- wall
		wcm.singleLine = "Humpty-Dumpty -sat on a wall. Humpty-Dumpty- had a great fall.";
		wcm.init();
		List<String> index = wcm.getIndex();

		assertEquals(index.indexOf("fall"), 1);
		assertEquals(index.indexOf("had"), 3);
		assertEquals(index.indexOf("wall"), 6);
	}
	
}
