package sk.linhard.wc;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordCounterTest {

	private static final DecimalFormat AVG_FORMAT = new DecimalFormat("0.00");

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

	@Test
	public void testUniqueCount() {
		assertCount(4, 2, "aaa aaa bbb bbb");
		assertCount(7, 6, "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", "the", "a", "on", "off");
	}

	@Test
	public void testUniqueCountCaseSensitive() {
		assertCount(4, 3, "aaa aaa Bbb bbb");
	}

	@Test
	public void testSeparators() {
		assertCount(4, 1, "aaa.aaa\naaa aaa");
	}

	@Test
	public void testHyphenWords() {
		assertCount(3, 1, "--- . --- . ---");
	}

	@Test
	public void testDashNoLongerSeparator() {
		assertCount(2, 2, "aaa.aaa-aaa");
	}

	@Test
	public void testAverageLength() {
		assertEquals("3.00", AVG_FORMAT.format(createCounter("aaaa aa aaaa aa").averageLength()));
		assertEquals("3.25", AVG_FORMAT.format(createCounter("aaaa aaa aaaa aa").averageLength()));
	}

	@Test
	public void testIndices() {
		WordCounter wc = createCounter("cc aa bb");
		List<String> index = wc.index();
		assertEquals("aa", index.get(0));
		assertEquals("bb", index.get(1));
		assertEquals("cc", index.get(2));
		assertEquals(3, index.size());
	}

	private WordCounter createCounter(String input, String... stopWords) {
		StringReader testInput = new StringReader(input);
		return new WordCounter(testInput, Arrays.asList(stopWords));
	}

	private void assertCountWithStopWords(int expectedCount, String input, String... stopWords) {
		assertCount(expectedCount, expectedCount, input, stopWords);
	}

	private void assertCount(int expectedCount, int expectedUniqueCount, String input, String... stopWords) {
		WordCounter wc = createCounter(input, stopWords);
		int actualCount = wc.count();
		int actualUniqueCount = wc.uniqueCount();
		assertEquals("Word count", expectedCount, actualCount);
		assertEquals("Unique word count", expectedUniqueCount, actualUniqueCount);
	}

	private void assertCount(int expectedCount, String input) {
		assertCountWithStopWords(expectedCount, input);
	}
}
