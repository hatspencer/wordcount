import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCountTest {

    @Test
    public void testGetWordSetAmountOfSplittedWords() {
        String testString = "aslkdjf asöldkjfa sdklöfj";
        String[] wordSet = WordCount.getWordSet(testString);

        assertEquals(3, wordSet.length);
    }

    @Test
    public void testFilteredStopWords() {
        String inputText = "on a plane";
        String[] stopWords = {"on", "a"};
        String[] wordSet = WordCount.getWordSet(inputText);
        String[] wordsWithoutStopwords = WordCount.filterStopWords(
                wordSet,
                stopWords
        );

        assertEquals(1, wordsWithoutStopwords.length);
    }

}
