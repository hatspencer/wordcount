package at.flwal.erste;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

	@Test
	public void lettersWithNumberBetweenShouldNotCounted() {
		assertThat(WordCount.count(TestData.NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpecialCharactersShouldNotBeCounted() {
		assertThat(WordCount.count(TestData.ALSO_NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(WordCount.count(TestData.TWO_WORDS), is(2));
	}

	@Test
	public void lettersWithMoreSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(WordCount.count(TestData.TWO_WORDS_WITH_MORE_SPACES), is(2));
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
		assertThat(WordCount.count(TestData.MORE_WORDS), is(4));
	}

	@Test
	public void lettersWithUmlautsAddedShouldNotBeCountedAsWords() {
		assertThat(WordCount.count(TestData.UMLAUTS_ARE_NOT_A_PART), is(2));
	}

}
