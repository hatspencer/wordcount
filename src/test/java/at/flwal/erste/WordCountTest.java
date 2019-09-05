package at.flwal.erste;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

	private static final String NOT_A_WORD = "Fo0o";
	private static final String ALSO_NOT_A_WORD = "Ba$r";
	private static final String TWO_WORDS = "Ba r ";
	private static final String TWO_WORDS_WITH_MORE_SPACES = "Ba  r  ";
	private static final String MORE_WORDS = " abba  BABBA cdfg jKL   ";
	private static final String UMLAUTS_ARE_NOT_A_PART = " abba   cdfg jKLö   ";

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

	@Test
	public void nullShouldNotCrash() {
		assertThat(WordCount.count(null), is(0));
	}

	@Test
	public void emptyTextShouldCountAsZero() {
		assertThat(WordCount.count(""), is(0));
	}

	@Test
	public void mixedCaseCombinationsShouldWork() {
		assertThat(WordCount.count(MORE_WORDS), is(4));
	}

	@Test
	public void lettersWithUmlautsAddedShouldNotBeCountedAsWords() {
		assertThat(WordCount.count(UMLAUTS_ARE_NOT_A_PART), is(2));
	}

}
