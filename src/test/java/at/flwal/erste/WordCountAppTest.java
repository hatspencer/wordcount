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

		ByteArrayInputStream in = new ByteArrayInputStream(TestData.NOT_A_WORD.getBytes());
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(buffer);

		WordCountApp.logic(in, out, new WordCount(Collections.<String>emptySet()));

		String s = buffer.toString().substring(SUFFIX.length());
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

}
