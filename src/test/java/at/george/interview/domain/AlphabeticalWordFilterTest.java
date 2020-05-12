package at.george.interview.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlphabeticalWordFilterTest {

    private StopWords stopWords;

    private AlphabeticalWordFilter sut;

    @Before
    public void setup() {
        stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        sut = new AlphabeticalWordFilter(stopWords);
    }

    @Test
    public void returnEmptyOnEmptyString() {

        List<String> filtered = sut.filterWords("");

        assertThat(filtered, is(emptyList()));
    }


    @Test
    public void returnEmptyOnWhitespaceOnlyString() {

        List<String> filtered = sut.filterWords("                   ");

        assertThat(filtered, is(emptyList()));
    }

    @Test
    public void filterStopWordLists() {

        List<String> filtered = sut.filterWords("you and me");

        assertThat(filtered, is(asList("and")));
    }

    @Test
    public void leaveNonStopWordsUnchanged() {

        List<String> filtered = sut.filterWords("Healthy and safe meetings");

        assertThat(filtered, is(asList("Healthy", "and", "safe", "meetings")));
    }

    @Test
    public void splitByNonAlphabeticalChars() {

        List<String> filtered = sut.filterWords("Humpty-Dumpty sat on a wall.");

        assertThat(filtered, is(asList("Humpty", "Dumpty", "sat", "on", "a", "wall")));
    }

}