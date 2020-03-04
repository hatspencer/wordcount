package wordcount;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordCounterTest {
	
	WordCounter counter = new WordCounter(new ArrayList<>());
	List<String> exlusions = Arrays.asList("the", "a", "on", "off");
	WordCounter counterWithExclusions = new WordCounter(exlusions);
	
	@Test
	public void empty() {
		assertEquals(0, counter.countWords(null));
		assertEquals(0, counter.countWords(""));
	}
	
	@Test
	public void oneWord() {
		assertEquals(1, counter.countWords("Foo"));
		assertEquals(1, counter.countWords("FooBar"));
	}
	
	@Test
	public void notWord() {
		assertEquals(0, counter.countWords("Foo1"));
		assertEquals(0, counter.countWords("Foo3Bar"));
		assertEquals(0, counter.countWords("Foo$Bar"));
		assertEquals(0, counter.countWords("Foo's"));
		assertEquals(0, counter.countWords("Fää"));
	}
	
	@Test
	public void twoWords() {
		assertEquals(2, counter.countWords("Foo Bar"));
		assertEquals(2, counter.countWords("Foo Bar."));
		assertEquals(2, counter.countWords("Humpty-Dumpty"));
	}
	
	@Test
	public void moreWords() {
		assertEquals(3, counter.countWords("  Foo Bar      Zoo   "));
		assertEquals(5, counter.countWords("Mary had a little lamb"));
	}
	
	@Test
	public void exclusions() {
		assertEquals(4, counterWithExclusions.countWords("Mary had a little lamb"));
		assertEquals(9, counterWithExclusions.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
	}
	
	@Test
	public void emptyUnique() {
		assertEquals(0, counter.countUniqueWords(null));
		assertEquals(0, counter.countUniqueWords(""));
	}
	
	@Test
	public void fewWordsUnique() {
		assertEquals(4, counter.countUniqueWords("Foo Foo Foo Bar Bar something else"));
	}
	
	@Test
	public void exclusionsUnique() {
		assertEquals(7, counterWithExclusions.countUniqueWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
	}

}
