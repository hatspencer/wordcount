import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void countInputWithOnlyValidWords() {
        WordCounter wc = new WordCounter();
        String str = "mary has a litle lamb";
        long numOfWords = wc.countValidWords(str);
        assertEquals(5, numOfWords);
    }

    @Test
    public void countInputWithOnlyInvalidWords() {
        WordCounter wc = new WordCounter();
        String str = "mary has a litle !lamb";
        long numOfWords = wc.countValidWords(str);
        assertEquals(4, numOfWords);
    }
}


