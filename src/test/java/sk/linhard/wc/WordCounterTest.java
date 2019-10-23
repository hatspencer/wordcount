package sk.linhard.wc;

import java.io.StringReader;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

	@Test
	public void testFileInput() {

	}

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
		assertCount(2, "foo ba$R aaa");
		assertCount(2, "foo ba$R aaa $$");
		assertCount(3, "foo ba$R aaa $$ bbb");
	}

	@Test
	public void testOtherWhitespace() {
		assertCount(0, " ");
		assertCount(0, "\t");
		assertCount(0, "foo\tbar");
	}

	@Test
	public void testMultiLineInput() {
		assertCount(5, "Mary had\na little\nlamb");
		assertCount(5, "Mary had\ra little\rlamb");
		assertCount(5, "Mary had\r\na little\r\nlamb");
	}

	@Test
	public void testStopWords() {
		assertCountWithStopWords(1, " foo bar", "bar");
		assertCountWithStopWords(1, " bar foo", "bar");
		assertCountWithStopWords(1, " $$ bar foo", "bar");
		assertCountWithStopWords(1, "foo bar", "bar");
		assertCountWithStopWords(0, "foo bar", "bar", "foo");
		assertCountWithStopWords(2, "foo bar abc", "bar");
	}

	@Test
	public void testStopWordsCaseSensitive() {
		assertCountWithStopWords(2, "foo bar", "Bar");
	}

	private void assertCountWithStopWords(int expectedCount, String input, String... stopWords) {
		StringReader testInput = new StringReader(input);
		WordCounter wc = new WordCounter(testInput, Arrays.asList(stopWords));
		Assert.assertEquals(expectedCount, wc.count());
	}

	private void assertCount(int expectedCount, String input) {
		assertCountWithStopWords(expectedCount, input);
	}
}
