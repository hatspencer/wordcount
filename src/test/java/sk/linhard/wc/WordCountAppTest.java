package sk.linhard.wc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Optional;

import org.junit.Test;

public class WordCountAppTest {
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	@Test
	public void testConsoleOutputNoIndex() throws Exception {
		assertEquals("Number of words: 4, unique: 3; average word length: 3.25 characters",
				createApp("aaaa aaa aaaa aa").computeOutput());
	}

	@Test
	public void testConsoleOutput() throws Exception {
		assertEquals("Number of words: 4, unique: 3; average word length: 3.25 characters\nIndex:\naa\naaa\naaaa",
				createApp("aaaa aaa aaaa aa").computeOutputWithIndex());
	}

	@Test
	public void testConsoleOutputFromExample() throws Exception {
		assertEquals(
				"Number of words: 4, unique: 4; average word length: 4.25 characters\nIndex:\nMary\nhad\nlamb\nlittle",
				createAppWithDefaultStopWords("Mary had a little lamb").computeOutputWithIndex());
	}

	@Test
	public void testConsoleOutputWithFileInput() throws Exception {
		assertEquals(
				"Number of words: 4, unique: 4; average word length: 4.25 characters\nIndex:\nMary\nhad\nlamb\nlittle",
				createAppWithDefaultInputAndStopWords().computeOutputWithIndex());
	}

	private WordCountApp createApp(String input) {
		return createApp(input, Optional.empty());
	}

	private WordCountApp createAppWithDefaultInputAndStopWords() throws IOException {
		return new WordCountApp(getDefaultInputReader(), UTF_8, getDefaultStopWords(), Optional.empty());
	}

	private Reader getDefaultInputReader() throws IOException {
		return new InputStreamReader(new FileInputStream(new File("src/test/resources/mytext.txt")), UTF_8);
	}

	private Optional<File> getDefaultStopWords() {
		return Optional.of(new File("src/test/resources/stopwords.txt"));
	}

	private Optional<File> getDefaultDictionary() {
		return Optional.of(new File("src/test/resources/dict.txt"));
	}

	private WordCountApp createAppWithDefaultStopWords(String input) {
		return createApp(input, getDefaultStopWords());
	}

	private WordCountApp createAppWithDictAndStopWords(String input) {
		return new WordCountApp(new StringReader(input), UTF_8, getDefaultStopWords(), getDefaultDictionary());
	}

	private WordCountApp createApp(String input, Optional<File> stopwords) {
		return new WordCountApp(new StringReader(input), UTF_8, stopwords, Optional.empty());
	}
}
