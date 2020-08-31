import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountExampleTest {
    WordCountExample wordCountExample = new WordCountExample();

    @Test
    void TestWithFiveWords() {
        assertEquals(5, wordCountExample.getWordCount("Mary had a little lamb"));
    }

    @Test
    void TestWithFiveWordsAndSpecialCharacter() {
        assertEquals(4, wordCountExample.getWordCount("Mary had a little lamb."));
    }

    @Test
    void TestWithEmptyString() {
        assertEquals(0, wordCountExample.getWordCount(""));
    }

    @Test
    void TestWithSingleCharacters() {
        assertEquals(5, wordCountExample.getWordCount("a b c d e     $     ?"));
    }

    @Test
    void TestWithSingleCharactersAndSpacesAround() {
        assertEquals(5, wordCountExample.getWordCount("     a b c d e     $     ?    "));
    }

    @Test
    void TestWithStopword() {
        assertEquals(4, wordCountExample.getWordCountWithoutStopWords("Mary had a little lamb"));
    }

    @Test
    void TestWithTwoStopwords() {
        assertEquals(4, wordCountExample.getWordCountWithoutStopWords("Mary had a little lamb on"));
    }
}
