package sk.linhard.wc;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Optional;

import org.junit.Test;

public class WordCountAppTest {
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	@Test
	public void testConsoleOutput() throws Exception {
		assertEquals("Number of words: 4, unique: 3; average word length: 3.25 characters",
				createApp("aaaa aaa aaaa aa").computeOutput());
	}

	private WordCountApp createApp(String input) {
		return new WordCountApp(new StringReader(input), UTF_8, Optional.empty());
	}
}
