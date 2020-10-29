import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounter(new StopWordReader());
    }

    @Test
    public void givenEmptyString_returnOneElementArray() {
        String textMock = "";

        String[] expected = new String[]{""};
        String[] actual = wordCounter.splitTextAtWhitespaceAndHyphen(textMock);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenOneWord_returnOne() {
        String[] words = new String[]{"word"};

        long expected = 1;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }

    @Test
    public void givenInvalidWord_returnZero() {
        String[] words = new String[]{"wo3rd", "234"};

        long expected = 0;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }

    @Test
    public void givenDuplicateWords_returnTwo() {
        String[] words = new String[]{"word", "word"};

        long expected = 2;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }

    @Test
    public void givenExampleInput_returnFour() {
        String[] words = new String[]{"Mary", "had", "a", "little", "lamb"};

        long expected = 4;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStopWordsOnlyInput_returnZero() {
        String[] words = new String[]{"a", "off", "a", "the", "on"};

        long expected = 0;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithHyphen_returnTwoElementArray() {
        String textMock = "Humpty-Dumpty";

        String[] expected = new String[]{"Humpty", "Dumpty"};
        String[] actual = wordCounter.splitTextAtWhitespaceAndHyphen(textMock);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void givenStringWithHyphenAndSpace_returnThreeElementArray() {
        String textMock = "Humpty-Dumpty sat";

        String[] expected = new String[]{"Humpty", "Dumpty", "sat"};
        String[] actual = wordCounter.splitTextAtWhitespaceAndHyphen(textMock);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void givenInputWithDots_returnCountOfNonStopWords() {
        String[] words = new String[]{"Humpty", "Dumpty", "sat", "on", "a", "wall.", "Humpty", "Dumpty", "had", "a", "great", "fall."};

        long expected = 9;
        long actual = wordCounter.countWords(words);

        assertEquals(expected, actual);
    }


    @Test
    public void givenInputWithDuplicates_returnCountOfDistinctNonStopWords() {
        String[] words = new String[]{"Humpty", "Dumpty", "sat", "on", "a", "wall.", "Humpty", "Dumpty", "had", "a", "great", "fall."};

        long expected = 7;
        long actual = wordCounter.countDistinctWords(words);

        assertEquals(expected, actual);
    }
}
