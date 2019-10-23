package sk.linhard.wc;

import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testInitialExample() {
		assertCount(5, "Mary had a little lamb");
	}

	@Test
	public void testBasicCounts() {
		assertCount(0, "  ");
		assertCount(0, "");
		assertCount(1, "foo");
		assertCount(2, "foo bar");
		assertCount(2, "   foo bar  ");
		assertCount(2, "foo bar  ");
		assertCount(2, "   foo bar");
	}

	@Test
	public void testOtherIllegalCharSegments() {
		assertCount(1, "foo b0ar");
		assertCount(1, "foo b_ar");
		assertCount(1, "foo b|ar");
	}

	@Test
	public void testSpecialChar() {
		assertCount(1, "foo");
		assertCount(1, "foo bar$");
		assertCount(1, "foo bar$ 012");
		assertCount(1, "foo ba$R");
		assertCount(1, "foo ba$R ");
	}

	@Test
	public void testOtherWhitespace() {
		assertCount(0, " ");
		assertCount(0, "\t");
		assertCount(0, "foo\tbar");
	}

	private void assertCount(int expectedCount, String input) {
		StringReader testInput = new StringReader(input);
		WordCounter wc = new WordCounter(testInput);
		Assert.assertEquals(expectedCount, wc.count());
	}
}
