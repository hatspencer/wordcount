import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordCounterTest {

    @Test
    public void isValidInputShouldReturnFalseOnInvalidInput() {
        String invalidInput = "foo bar1";

        boolean result = WordCounter.isValidInput(invalidInput);

        assertFalse(result);
    }

    @Test
    public void isValidInputShouldNotReturnFalseIfInputContainsHyphen() {
        String hyphenInput = "Humpty-Dumpty";

        boolean result = WordCounter.isValidInput(hyphenInput);

        assertTrue(result);
    }

    @Test
    public void isValidInputShouldReturnTrueOnValidInput() {
        String validInput = "foo bar";

        boolean result = WordCounter.isValidInput(validInput);

        assertTrue(result);
    }

    @Test
    public void isValidInputShouldReturnTrueOnNoInput() {
        String noInput = "";

        boolean result = WordCounter.isValidInput(noInput);

        assertTrue(result);
    }

    @Test
    public void findWordsReturnsCorrectCollectionOfWords() {
        String twoWords = "foo bar";
        Collection<String> expectedResult = Arrays.asList("foo", "bar");

        Collection<String> result = WordCounter.findValidWords(twoWords);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsCountsHyphenatedWordsAsSeparateWords() {
        String hyphenInput = "Humpty-Dumpty";
        Collection<String> expectedResult = Arrays.asList("Humpty", "Dumpty");


        Collection<String> result = WordCounter.findValidWords(hyphenInput);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsReturnsCorrectCollectionOfWordsWhenInputHasHyphsensAndWhitespaces() {
        String hyphenInput = "Humpty-Dumpty sat down over-there";
        Collection<String> expectedResult = Arrays.asList("Humpty", "Dumpty", "sat", "down", "over", "there");


        Collection<String> result = WordCounter.findValidWords(hyphenInput);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsReturnsCorrectCollectionOfWordsWithMultipleSpaces() {
        String twoWords = "foo     bar";
        Collection<String> expectedResult = Arrays.asList("foo", "bar");


        Collection<String> result = WordCounter.findValidWords(twoWords);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsReturnsZeroOnNoInput() {
        String noInput = "";
        Collection<String> expectedResult = Collections.emptyList();


        Collection<String> result = WordCounter.findValidWords(noInput);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsReturnsZeroOnEmptyInput() {
        String emptyInput = " ";
        Collection<String> expectedResult = Collections.emptyList();


        Collection<String> result = WordCounter.findValidWords(emptyInput);

        assertEquals(expectedResult, result);
    }

    @Test
    public void findWordsReturnsCorrectCollectionOfWordsIgnoringStopWords() {
        List<String> stopWords = Arrays.asList("a", "off", "the", "on");
        String oneInvalidWord = "Mary had a little lamb";
        Collection<String> expectedResult = Arrays.asList("Mary", "had", "little", "lamb");


        Collection<String> result = WordCounter.findValidWords(oneInvalidWord, stopWords);

        assertEquals(expectedResult, result);
    }

    @Test
    public void fetchInputStringFromPathCreatesInputStringFromFile() {
        String filePath = "myInput.txt";

        String result = WordCounter.fetchInputStringFromPath(filePath);

        String expectedResult = "Mary had a little lamb";
        assertEquals(expectedResult, result);
    }


}
