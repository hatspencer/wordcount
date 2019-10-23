package sk.linhard.wc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Optional;

import org.junit.Test;

public class WordCountAppTest {
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	@Test
	public void testConsoleOutput() throws Exception {
		assertEquals("Number of words: 4, unique: 3; average word length: 3.25 characters\nIndex:\naa\naaa\naaaa",
				createApp("aaaa aaa aaaa aa").computeOutput());
	}

	@Test
	public void testConsoleOutputFromExample() throws Exception {
		assertEquals(
				"Number of words: 4, unique: 4; average word length: 4.25 characters\nIndex:\nMary\nhad\nlamb\nlittle",
				createAppWithDefaultStopWords("Mary had a little lamb").computeOutput());
	}

	private WordCountApp createApp(String input) {
		return createApp(input, Optional.empty());
	}

	private WordCountApp createAppWithDefaultStopWords(String input) {
		return createApp(input, Optional.of(new File("src/test/resources/stopwords.txt")));
	}

	private WordCountApp createApp(String input, Optional<File> stopwords) {
		return new WordCountApp(new StringReader(input), UTF_8, stopwords);
	}
}
