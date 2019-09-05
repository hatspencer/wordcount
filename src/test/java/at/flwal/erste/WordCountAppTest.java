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

	private static final String SUFFIX = WordCountApp.PROMPT_TEXT + WordCountApp.RESULT_PREFIX;
	private static final String TEST_RESOURCES_PATH = "src/test/resources";
	private static final String TEST_STOPWORDS_PATH = TEST_RESOURCES_PATH + "/stopwords.txt";
	private static final String TEST_INPUT_FILE_PATH = TEST_RESOURCES_PATH + "/mytext.txt";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void mainCallCLIModeWithStopwordsShouldWork() {

		TestIO io = createIO();

		Mode mode = WordCountApp.detectMode(new String[0]);
		Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TEST_STOPWORDS_PATH));
		WordCount wordCount = new WordCount(stopwords);
		//TODO use mode param?
		WordCountApp.logic(io.inputStream, io.outputStream, wordCount);

		assertWordCount(io.buffer, 0);
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
		expectedEx.expectMessage("Could not find stopwords file");

		WordCountApp.loadStopwords(Paths.get(TEST_RESOURCES_PATH + "/fileNotFound.text"));
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

	@Test
	public void logicWithInputFileShouldWork() {

		try(TestIO io = createIO()) {
			WordCount wordCount = new WordCount(emptySet());
			WordCountApp.logicWithInputFile(TEST_INPUT_FILE_PATH, wordCount, io.outputStream);
			assertWordCount(io.buffer, 5);
		} catch (IOException e){
			//ignore
		}
	}

	@Test
	public void logicWithInputFileAndStopwordsShouldWork() {

		try(TestIO io = createIO()) {
			Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TEST_STOPWORDS_PATH));
			WordCount wordCount = new WordCount(stopwords);
			WordCountApp.logicWithInputFile(TEST_INPUT_FILE_PATH, wordCount, io.outputStream);
			assertWordCount(io.buffer, 4);
		} catch (IOException e){
			//ignore
		}
	}

	private static void assertWordCount(ByteArrayOutputStream buffer, int expected) {
		String printed = buffer.toString().substring(SUFFIX.length());
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
