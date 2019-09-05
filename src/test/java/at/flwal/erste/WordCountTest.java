package at.flwal.erste;

import at.flwal.erste.test.TestData;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

	private WordCount wordCount;

	@Before
	public void setUp() {
		wordCount = new WordCount(Collections.emptySet());
	}

	@Test
	public void lettersWithNumberBetweenShouldNotCounted() {
		assertThat(wordCount.count(TestData.NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpecialCharactersShouldNotBeCounted() {
		assertThat(wordCount.count(TestData.ALSO_NOT_A_WORD), is(0));
	}

	@Test
	public void lettersWithSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(wordCount.count(TestData.TWO_WORDS), is(2));
	}

	@Test
	public void lettersWithMoreSpacesInBetweenShouldBeCountedAsTwoWords() {
		assertThat(wordCount.count(TestData.TWO_WORDS_WITH_MORE_SPACES), is(2));
	}

	@Test
	public void nullShouldNotCrash() {
		assertThat(wordCount.count(null), is(0));
	}

	@Test
	public void emptyTextShouldCountAsZero() {
		assertThat(wordCount.count(""), is(0));
	}

	@Test
	public void mixedCaseCombinationsShouldWork() {
		assertThat(wordCount.count(TestData.MORE_WORDS), is(4));
	}

	@Test
	public void lettersWithUmlautsAddedShouldNotBeCountedAsWords() {
		assertThat(wordCount.count(TestData.UMLAUTS_ARE_NOT_A_PART), is(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyStopWordsShouldFailFast() {
		new WordCount(null);
	}

	@Test
	public void designatedStopWordShouldNotBeCounted() {
		WordCount wordCount = withStopwords(singletonList("the"));
		assertThat(wordCount.count(TestData.TWO_WORDS_AND_ONE_DESIGNATED_STOPWORD), is(2));
	}

	@Test
	public void designatedMultipleStopWordShouldNotBeCounted() {
		WordCount wordCount = withStopwords(singletonList("the"));
		assertThat(wordCount.count(TestData.TWO_WORDS_AND_SAME_STOPWORD_TWICE), is(2));
	}

	@Test
	public void designatedStopWordsShouldNotBeFixed() {
		WordCount wordCount = withStopwords(singletonList("a"));
		assertThat(wordCount.count(TestData.TWO_WORDS_AND_ONE_DESIGNATED_STOPWORD), is(3));
	}

	@Test
	public void multipleStopwordsInListShouldWork() {
		WordCount wordCount = withStopwords(asList("a", "the"));
		assertThat(wordCount.count(TestData.TWO_WORDS_AND_ONE_DESIGNATED_STOPWORD), is(2));
	}

	@Test
	public void multipleStopwordsInListAndInputShouldWork() {
		WordCount wordCount = withStopwords(asList("a", "the"));
		assertThat(wordCount.count(TestData.TWO_WORDS_WITH_TWO_DESIGNATED_STOPWORDs), is(2));
	}

	private static WordCount withStopwords(List<String> strings) {
		return new WordCount(new HashSet<>(strings));
	}

}
