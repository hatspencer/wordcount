package at.flwal.erste;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

	private static final String SUFFIX = WordCountApp.PROMPT_TEXT + WordCountApp.RESULT_TEXT;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void callingAppWithLettersWithNumberBetweenShouldNotCounted() {

		TestIO io = createIO();

		WordCountApp.logic(io.inputStream, io.outputStream, new WordCount(Collections.<String>emptySet()));

		String s = io.buffer.toString().substring(SUFFIX.length());
		Integer integer = Integer.valueOf(s);
		assertThat(integer, is(0));
	}

	@Test
	public void callingLogicWithWordCounterShouldFail() {

		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Wordcounter not initialized.");

		WordCountApp.logic(null, null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void loadWordCounterWithNoStopwordsPathShouldNotWork() {
		WordCountApp.loadStopwords(null);
	}

	@Test
	public void loadStopwordsShouldWork() {
		Set<String> stopwords = WordCountApp.loadStopwords(Paths.get("src/test/resources/stopwords.txt"));
		assertThat(stopwords, hasItems("the", "on", "a", "off"));
	}

	@Test
	public void loadStopwordsWithInvalidPathShouldFail() {

		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("Could not find stopwords file");

		WordCountApp.loadStopwords(Paths.get("src/test/resources/stopwords.text"));
	}

	@Test
	public void detectModeWithNoArgsShouldReturnCLIMode() {

		String[] args = new String[0];
		Mode mode = WordCountApp.detectMode(args);
		assertThat(mode, is(Mode.CLI));
	}

	@Test
	public void detectModeWithOneArgShouldReturnFileMode() {

		String[] args = new String[]{"mytext.txt"};
		Mode mode = WordCountApp.detectMode(args);
		assertThat(mode, is(Mode.FILE));
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(expected = IllegalArgumentException.class)
	public void detectModeWithTooManyArgumentsShouldFail() {
		String[] args = new String[]{"mytext.txt", "bla"};
		WordCountApp.detectMode(args);
	}

	private static TestIO createIO() {
		TestIO testIO = new TestIO();
		testIO.inputStream = new ByteArrayInputStream(TestData.NOT_A_WORD.getBytes());
		testIO.buffer = new ByteArrayOutputStream();
		testIO.outputStream = new PrintStream(testIO.buffer);
		return testIO;
	}

	private static class TestIO {
		ByteArrayInputStream inputStream;
		ByteArrayOutputStream buffer;
		PrintStream outputStream;
	}

}
