package hiring;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BasicWordCounterTest {

    @Test
    public void countWords_emptyStopWords() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository();
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        Assert.assertEquals(1, wordCounter.countWords("word"));
        Assert.assertEquals(3, wordCounter.countWords("word word word"));
        Assert.assertEquals(4, wordCounter.countWords("word word        word      word"));
        Assert.assertEquals(3, wordCounter.countWords("word\nword\tword"));
        Assert.assertEquals(0, wordCounter.countWords("word, word. word!"));
        Assert.assertEquals(0, wordCounter.countWords("word1word 2word word5"));
        Assert.assertEquals(0, wordCounter.countWords("$word wor%d word&"));
    }

    @Test
    public void countWords_testStopWords() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository("a", "alpha", "beta");
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        Assert.assertEquals(1, wordCounter.countWords("alpha a beta a gamma"));
    }

    private StopWordsRepository mockStopWordsRepository(String... words) {
        return word -> Arrays.asList(words).contains(word);
    }
}
