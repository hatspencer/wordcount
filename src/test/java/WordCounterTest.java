import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounter(new StopWordReader());
    }

    @Test
    public void givenOneWord_returnOne() {
        String text = "word";

        long expected = 1;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenInvalidWord_returnZero() {
        String text = "wo3rd 234";

        long expected = 0;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenDuplicateWords_returnTwo() {
        String text = "word word";

        long expected = 2;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenExampleInput_returnFour() {
        String text = "Mary had a little lamb";

        long expected = 4;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStopWordsOnlyInput_returnZero() {
        String text = "a off a the on";

        long expected = 0;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenInputWithDots_returnCountOfNonStopWords() {
        String text = "Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.";

        long expected = 9;
        long actual = wordCounter.countWords(text);

        assertEquals(expected, actual);
    }

    @Test
    public void givenInputWithDuplicates_returnCountOfDistinctNonStopWords() {
        String text = "Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.";

        long expected = 7;
        long actual = wordCounter.countUniqueWords(text);

        assertEquals(expected, actual);
    }
}
