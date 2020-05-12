package at.george.interview.domain.unique;

import at.george.interview.domain.StopWords;
import at.george.interview.domain.counters.AlphabeticWordCounter;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlphabeticUniquenessCalculatorTest {

    private StopWords stopWords;

    private AlphabeticUniquenessCalculator sut;

    @Before
    public void setup() {
        stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        sut = new AlphabeticUniquenessCalculator(stopWords);
    }

    @Test
    public void leaveNonDuplicatesAsTheyAre() {

        long result = sut.getUniqueWords("hello world here I am");

        assertThat(result, is(5L));
    }

    @Test
    public void filterDuplicates() {

        long result = sut.getUniqueWords("hello world hello world");

        assertThat(result, is(2L));
    }

    @Test
    public void ignoreStopWords() {

        long result = sut.getUniqueWords("hello world how are you"); // "you" = stopword

        assertThat(result, is(4L));
    }

    @Test
    public void treatNonAlphabeticalCharsAsWhitespaces() {

        stopWords = StopWords.fromList(asList("the", "a", "on", "off"));
        sut = new AlphabeticUniquenessCalculator(stopWords);

        long result = sut.getUniqueWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");

        assertThat(result, is(7L));
    }
}