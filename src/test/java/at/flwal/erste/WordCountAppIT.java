package at.flwal.erste;

import at.flwal.erste.test.TestData;
import at.flwal.erste.test.TestIO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.Paths;
import java.util.Set;

import static at.flwal.erste.test.WordCountAssertion.assertWordCount;

public class WordCountAppIT {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void mainCallCLIModeWithStopwordsShouldWork() throws Exception {

		try (TestIO io = TestIO.createIO(TestData.NOT_A_WORD)) {

			String[] args = new String[0];
			Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TestData.TEST_STOPWORDS_PATH));
			WordCount wordCount = new WordCount(stopwords);
			WordCountApp.callCount(Mode.fromArgs(args), io.inputStream, io.outputStream, wordCount, args);

			assertWordCount(io.buffer, 0, Mode.CLI);
		}
	}

	@Test
	public void mainCallFileModeWithStopwordsShouldWork() throws Exception {

		try (TestIO io = TestIO.createIO(TestData.NOT_A_WORD)) {
			Set<String> stopwords = WordCountApp.loadStopwords(Paths.get(TestData.TEST_STOPWORDS_PATH));
			WordCount wordCount = new WordCount(stopwords);
			WordCountApp.callCount(Mode.FILE, io.inputStream, io.outputStream, wordCount, new String[]{TestData.TEST_INPUT_FILE_PATH});

			assertWordCount(io.buffer, 4, Mode.FILE);
		}
	}

}
