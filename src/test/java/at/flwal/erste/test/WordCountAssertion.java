package at.flwal.erste.test;

import at.flwal.erste.Mode;
import at.flwal.erste.WordCountApp;
import at.flwal.erste.WordCountAppTest;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//TODO turn into a matcher
public class WordCountAssertion {

	private static final String SUFFIX_CLI_MODE = WordCountApp.PROMPT_TEXT + WordCountApp.RESULT_PREFIX;
	private static final String SUFFIX_FILE_MODE = WordCountApp.RESULT_PREFIX;

	public static void assertWordCount(ByteArrayOutputStream buffer, int expected, Mode mode) {

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
}
