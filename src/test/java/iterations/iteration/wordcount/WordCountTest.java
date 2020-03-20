package iterations.iteration.wordcount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	
	WordCount wordCount;
	
	public final static double DOUBLE_COMPARISON_DELTA = 0.0000000001;
	
	@Before
	public void setUp() {
		wordCount = new WordCount();
	}

	@Test
	public void countWordsTest() {
		assertEquals(wordCount.countWords(""), 0);
		assertEquals(wordCount.countWords("blabla"), 1);
		assertEquals(wordCount.countWords("word1 word2 wordDrei"), 1);
		assertEquals(wordCount.countWords("aabb ccff dfgndjkf 4dfg48 rr$"), 3);
		assertEquals(wordCount.countWords("yyy5yyyyy"), 0);
		assertEquals(wordCount.countWords("  dfgdf df "), 2);
		assertEquals(wordCount.countWords("  dfgdf	dfgdfg	dfgdfgdfgfg "), 3);
		assertEquals(wordCount.countWords("  dfgdf	 	 	dfgdfg	dfgdfgdfgfg "), 3);
	}

	@Test
	public void countWordsWithStopWordsTest() {
		
		wordCount.addStopWords("df", "aabb", "dfgdf");
		
		assertEquals(wordCount.countWords(""), 0);
		assertEquals(wordCount.countWords("blabla"), 1);
		assertEquals(wordCount.countWords("word1 word2 wordDrei"), 1);
		assertEquals(wordCount.countWords("aabb ccff dfgndjkf 4dfg48 rr$"), 2);
		assertEquals(wordCount.countWords("yyy5yyyyy"), 0);
		assertEquals(wordCount.countWords("  dfgdf df "), 0);
		assertEquals(wordCount.countWords("  dfgdf	dfgdfg	dfgdfgdfgfg "), 2);
		assertEquals(wordCount.countWords("  dfgdf	 	 	dfgdfg	dfgdfgdfgfg "), 2);
	}
	
	@Test
	public void countWordWithDashAsSeparator() {
		wordCount.setWordsSeparator("[ ,\\t,\\-]");
		assertEquals(wordCount.countWords("Humpty-Dumpty-blabla  -  hallo-world"), 5);
		wordCount.setWordsSeparator("[ ,\\t,\\-,\\.]");
		assertEquals(wordCount.countWords("Humpty-Dumpty-blabla  -  hallo-world"), 5);
	}

	@Test
	public void averageWordsLengthTest() {
		assertEquals(wordCount.averageWordLength("aa aa bb gg ee gg ds"), 2.0, DOUBLE_COMPARISON_DELTA);
		assertEquals(wordCount.averageWordLength("a aa aaa abab aba dinosaur"), 3.5, DOUBLE_COMPARISON_DELTA);
		assertEquals(wordCount.averageWordLength("a aa aaa abab abcde abcdef"), 3.5, DOUBLE_COMPARISON_DELTA);
		assertEquals(wordCount.averageWordLength("a aa aaa abab abcde abcdef ggggggg"), 4.0, DOUBLE_COMPARISON_DELTA);
	}

	@Test
	public void collectWordsTest() {
		
		wordCount.addStopWords("df", "aabb", "dfgdf");
		
		List<String> words = wordCount.collectValidWords("word1 word2 wordDrei");
		assertTrue(words.contains("wordDrei"));
		assertTrue(!words.contains("word1"));
		
		words = wordCount.collectValidWords("aabb ccff dfgndjkf 4dfg48 rr$");
		assertTrue(!words.contains("aabb"));
		assertTrue(words.contains("dfgndjkf"));
		assertTrue(words.contains("ccff"));
		assertTrue(!words.contains("4dfg48"));
		assertTrue(!words.contains("rr$"));
	}

}
