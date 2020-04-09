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

    @Test
    public void shouldCountMoreWords(){
        int actualCount = WordCounter.countWords("Word Word");

        Assert.assertEquals(2, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreMoreWhitespaces(){
        int actualCount = WordCounter.countWords("Word     Word");

        Assert.assertEquals(2, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreNumbersInWord(){
        int actualCount = WordCounter.countWords("Word W0rd");

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreSpecialCharactersInWord(){
        int actualCount = WordCounter.countWords("Word W$rd");

        Assert.assertEquals(1, actualCount);
    }
}
