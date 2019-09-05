package at.flwal.erste;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

	private static final String SUFFIX = WordCountApp.PROMPT_TEXT + WordCountApp.RESULT_TEXT;

	@Test
	public void callingAppWithLettersWithNumberBetweenShouldNotCounted() {

		ByteArrayInputStream in = new ByteArrayInputStream(TestData.NOT_A_WORD.getBytes());
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(buffer);

		WordCountApp.logic(in, out);

		String s = buffer.toString().substring(SUFFIX.length());
		Integer integer = Integer.valueOf(s);
		assertThat(integer, is(0));
	}

}
