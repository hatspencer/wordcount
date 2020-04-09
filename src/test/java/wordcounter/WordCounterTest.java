package wordcounter;

import org.junit.Assert;
import org.junit.Test;
import wordcounter.WordCounter;

public class WordCounterTest {

    @Test
    public void shouldCountOneWord(){
        int actualCount = WordCounter.countWords("Word");

        Assert.assertEquals(1, actualCount);
    }
}
