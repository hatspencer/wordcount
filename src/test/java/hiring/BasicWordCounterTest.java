package hiring;

import org.junit.Assert;
import org.junit.Test;

public class BasicWordCounterTest {

    @Test
    public void countWords() {
        WordCounter wordCounter = new BasicWordCounter();

        Assert.assertEquals(1, wordCounter.countWords("word"));
        Assert.assertEquals(3, wordCounter.countWords("word word word"));
        Assert.assertEquals(4, wordCounter.countWords("word word        word      word"));
        Assert.assertEquals(3, wordCounter.countWords("word\nword\tword"));
        Assert.assertEquals(0, wordCounter.countWords("word, word. word!"));
        Assert.assertEquals(0, wordCounter.countWords("word1word 2word word5"));
        Assert.assertEquals(0, wordCounter.countWords("$word wor%d word&"));
    }
}
