package at.george.interview.domain.counters;

import at.george.interview.domain.filter.AlphabeticalWordFilter;
import at.george.interview.domain.StopWords;
import at.george.interview.domain.filter.WordFilter;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FilteringWordCounterTest {

    private FilteringWordCounter sut;

    @Before
    public void setup() {
        StopWords stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        WordFilter wordFilter = new AlphabeticalWordFilter(stopWords);
        sut = new FilteringWordCounter(wordFilter);
    }

    @Test
    public void emptyInputReturnsZero() {

        long result = sut.countWords("");

        assertEquals(result, 0);
    }

    @Test
    public void whitespaceOnlyInputReturnsUZero() {

        long result = sut.countWords("        ");

        assertEquals(result, 0);
    }

    @Test
    public void singleWordReturnsOne() {

        long result = sut.countWords("hello");

        assertEquals(result, 1);
    }

    @Test
    public void twoWordsReturnsTwo() {

        long result = sut.countWords("hello there");

        assertEquals(result, 2);
    }

    @Test
    public void nonalphabeticWordIsIgnored() {

        long result = sut.countWords("hello1world");

        assertEquals(result, 2);
    }

    @Test
    public void ignoreSingleNonAlphabeticElements() {

        long result = sut.countWords("hello ? # ??? &");

        assertEquals(result, 1);
    }

    @Test
    public void ignoreStopWords() {

        long result = sut.countWords("Hello how are you"); // ignore "a"

        assertEquals(result, 3);
    }

    @Test
    public void treatNonAlphabeticCharsAsWhitespaces() {

        StopWords stopWords = StopWords.fromList(asList("the", "a", "on", "off"));
        WordFilter wordFilter = new AlphabeticalWordFilter(stopWords);
        sut = new FilteringWordCounter(wordFilter);

        long result = sut.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");

        assertEquals( 7, result);
    }
}