package at.flwal.erste;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

	private static final String NOT_A_WORD = "Fo0o";
	private static final String ALSO_NOT_A_WORD = "Ba$r";
	private static final String TWOW_WORDS = "Ba r ";

	@Test
	public void lettersWithNumberBetweenShouldNotCountAsWord() throws Exception {
		assertThat(WordCount.count(NOT_A_WORD), is(0));
	}

}
