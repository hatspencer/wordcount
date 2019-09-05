package at.flwal.erste;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

	private static final String NOT_A_WORD = "Fo0o";
	private static final String ALSO_NOT_A_WORD = "Ba$r";
	private static final String TWO_WORDS = "Ba r ";
	private static final String TWO_WORDS_WITH_MORE_SPACES = "Ba  r  ";

	@Test
	public void lettersWithNumberBetweenShouldNotCounted() {
		assertThat(WordCount.count(NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpecialCharactersShouldNotBeCounted() {
		assertThat(WordCount.count(ALSO_NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(WordCount.count(TWO_WORDS), is(2));
	}

	@Test
	public void lettersWithMoreSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(WordCount.count(TWO_WORDS_WITH_MORE_SPACES), is(2));
	}

}
