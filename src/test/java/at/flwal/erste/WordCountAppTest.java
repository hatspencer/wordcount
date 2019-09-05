package at.flwal.erste;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Set;

import static java.util.Collections.emptySet;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

	private static final String SUFFIX_CLI_MODE = WordCountApp.PROMPT_TEXT + WordCountApp.RESULT_PREFIX;
	private static final String SUFFIX_FILE_MODE = WordCountApp.RESULT_PREFIX;
	private static final String TEST_RESOURCES_PATH = "src/test/resources";
	private static final String TEST_STOPWORDS_PATH = TEST_RESOURCES_PATH + "/stopwords.txt";
	private static final String TEST_INPUT_FILE_PATH = TEST_RESOURCES_PATH + "/mytext.txt";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void mainCallCLIModeWithStopwordsShouldWork() throws Exception {

		try (TestIO io = createIO()) {

			String[] args = new String[0];
			Mode mode = Mode.fromArgs(args);
			Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TEST_STOPWORDS_PATH));
			WordCount wordCount = new WordCount(stopwords);
			//TODO use mode param?
			WordCountApp.logic(io.inputStream, io.outputStream, wordCount);

			assertWordCount(io.buffer, 0, Mode.CLI);
		}
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
		Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TEST_RESOURCES_PATH + "/stopwords.txt"));
		assertThat(stopwords, hasItems("the", "on", "a", "off"));
	}

	@Test
	public void loadStopwordsWithInvalidPathShouldFail() {

		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("Could not find file for stopwords");

		WordCountApp.loadStopwords(Paths.get(TEST_RESOURCES_PATH + "/fileNotFound.text"));
	}

	@Test
	public void logicWithInputFileShouldWork() throws Exception {

		try (TestIO io = createIO()) {
			WordCount wordCount = new WordCount(emptySet());
			WordCountApp.callCount(Mode.FILE, io.inputStream, io.outputStream, wordCount, new String[]{TEST_INPUT_FILE_PATH});
			assertWordCount(io.buffer, 5, Mode.FILE);
		}
	}

	@Test
	public void logicWithInputFileAndStopwordsShouldWork() throws Exception {

		try (TestIO io = createIO()) {
			Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TEST_STOPWORDS_PATH));
			WordCount wordCount = new WordCount(stopwords);
			WordCountApp.callCount(Mode.FILE, io.inputStream, io.outputStream, wordCount, new String[]{TEST_INPUT_FILE_PATH});
			assertWordCount(io.buffer, 4, Mode.FILE);
		}
	}



	private static void assertWordCount(ByteArrayOutputStream buffer, int expected, Mode mode) {

		String printed;
		switch (mode) {
			case CLI:
				printed = buffer.toString().substring(SUFFIX_CLI_MODE.length());
				break;
			case FILE:
				printed = buffer.toString().substring(SUFFIX_FILE_MODE.length());
				break;
			default:
				throw new IllegalArgumentException("Unknown mode: " + mode);
		}

		Integer count = Integer.valueOf(printed);
		assertThat(count, is(expected));
	}

	private static TestIO createIO() {
		TestIO testIO = new TestIO();
		testIO.inputStream = new ByteArrayInputStream(TestData.NOT_A_WORD.getBytes());
		testIO.buffer = new ByteArrayOutputStream();
		testIO.outputStream = new PrintStream(testIO.buffer);
		return testIO;
	}

	private static class TestIO implements Closeable {

		ByteArrayInputStream inputStream;
		ByteArrayOutputStream buffer;
		PrintStream outputStream;

		@Override
		public void close() throws IOException {
			inputStream.close();
			outputStream.close();
			buffer.close();
		}

	}
}
