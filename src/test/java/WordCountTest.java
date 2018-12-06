import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCountTest {

    @Test
    public void testGetWordSetAmountOfSplittedWords() {
        String testString = "aslkdjf asöldkjfa sdklöfj";
        String[] wordSet = WordCount.getWordSet(testString);

        assertEquals(3, wordSet.length);
    }

}
