package at.flwal.erste;

import at.flwal.erste.test.TestData;
import at.flwal.erste.test.TestIO;
import at.flwal.erste.test.WordCountAssertion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
import java.util.Set;

import static java.util.Collections.emptySet;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void callingLogicWithWordCounterShouldFail() {

		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Wordcounter not initialized.");

		WordCountApp.callCount(Mode.CLI, null, null, null, new String[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void loadWordCounterWithNoStopwordsPathShouldNotWork() {
		WordCountApp.loadStopwords(null);
	}

	@Test
	public void loadStopwordsShouldWork() {
		Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TestData.TEST_RESOURCES_PATH + "/stopwords.txt"));
		assertThat(stopwords, hasItems("the", "on", "a", "off"));
	}

	@Test
	public void loadStopwordsWithInvalidPathShouldFail() {

		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("Could not find file for stopwords");

		WordCountApp.loadStopwords(Paths.get(TestData.TEST_RESOURCES_PATH + "/fileNotFound.text"));
	}

	@Test
	public void logicWithInputFileShouldWork() throws Exception {

		try (TestIO io = TestIO.createIO(TestData.NOT_A_WORD)) {
			WordCount wordCount = new WordCount(emptySet());
			WordCountApp.callCount(Mode.FILE, io.inputStream, io.outputStream, wordCount, new String[]{TestData.TEST_INPUT_FILE_PATH});
			WordCountAssertion.assertWordCount(io.buffer, 5, Mode.FILE);
		}
	}

}
