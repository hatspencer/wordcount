package at.george.interview.domain.unique;

import at.george.interview.domain.filter.AlphabeticalWordFilter;
import at.george.interview.domain.StopWords;
import at.george.interview.domain.filter.WordFilter;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilteringUniquenessCalculatorTest {

    private StopWords stopWords;

    private FilteringUniquenessCalculator sut;

    @Before
    public void setup() {
        StopWords stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        WordFilter wordFilter = new AlphabeticalWordFilter(stopWords);
        sut = new FilteringUniquenessCalculator(wordFilter);
    }

    @Test
    public void leaveNonDuplicatesAsTheyAre() {

        long result = sut.countUniqueWords("hello world here I am");

        assertThat(result, is(5L));
    }

    @Test
    public void filterDuplicates() {

        long result = sut.countUniqueWords("hello world hello world");

        assertThat(result, is(2L));
    }

    @Test
    public void ignoreStopWords() {

        long result = sut.countUniqueWords("hello world how are you"); // "you" = stopword

        assertThat(result, is(4L));
    }

    @Test
    public void treatNonAlphabeticalCharsAsWhitespaces() {


        StopWords stopWords = StopWords.fromList(asList("the", "a", "on", "off"));
        WordFilter wordFilter = new AlphabeticalWordFilter(stopWords);
        sut = new FilteringUniquenessCalculator(wordFilter);

        long result = sut.countUniqueWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");

        assertThat(result, is(6L));
    }
}