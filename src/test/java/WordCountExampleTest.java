import org.junit.jupiter.api.Disabled;
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
        assertEquals(5, wordCountExample.getWordCount("Mary had a little lamb."));
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

    @Test
    void TestReadText() {
        String text = wordCountExample.readText("./src/main/resources/mytextfortest.txt");
        assertEquals("Mary had a little lamb ", text);
    }

    @Test
    void TestWordCountUniqueWithTwoSentences() {
        int wordCountUnique = wordCountExample.getWordCountUnique("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(7, wordCountUnique);
    }

    @Test
    void TestWordCountUniqueWithThreeSentences() {
        int wordCountUnique = wordCountExample.getWordCountUnique("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall. Humpty-Dumpty had a great fall.");
        assertEquals(7, wordCountUnique);
    }

    @Test
    void TestWordCountUniqueWithOneSentence() {
        int wordCountUnique = wordCountExample.getWordCountUnique("Humpty-Dumpty sat on a wall.");
        assertEquals(4, wordCountUnique);
    }

    @Test
    void TestWordCountUniqueEmpty() {
        int wordCountUnique = wordCountExample.getWordCountUnique("");
        assertEquals(0, wordCountUnique);
    }
}
