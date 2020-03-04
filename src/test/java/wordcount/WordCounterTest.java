package wordcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordCounterTest {
	
	WordCounter counter = new WordCounter();
	
	@Test
	public void empty() {
		assertEquals(0, counter.countWords(""));
	}
	
	@Test
	public void oneWord() {
		assertEquals(1, counter.countWords("Foo"));
		assertEquals(1, counter.countWords("FooBar"));
		assertEquals(1, counter.countWords("Foo Bar."));
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
	}
	
	@Test
	public void moreWords() {
		assertEquals(3, counter.countWords("  Foo Bar      Zoo   "));
	}

}
