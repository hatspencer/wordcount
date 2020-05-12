package at.george.interview.domain.counters;

import at.george.interview.domain.StopWords;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class AlphabeticWordCounterTest {

    private StopWords stopWords;

    private AlphabeticWordCounter sut;

    @Before
    public void setup() {
        stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        sut = new AlphabeticWordCounter(stopWords);
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
    public void splitByEvertythingNonAlphabetical() {

        String[] elements = sut.splitToElements("Humpty-Dumpty sat on a wall.");

        assertEquals(elements.length, 6);
    }

    @Test
    public void treatNonAlphabeticCharsAsWhitespaces() {

        stopWords = StopWords.fromList(asList("the", "a", "on", "off"));
        sut = new AlphabeticWordCounter(stopWords);

        long result = sut.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");

        assertEquals( 9, result);
    }
}