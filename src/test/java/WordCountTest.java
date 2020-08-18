import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    WordCount wordCount;


    @Before
    public void setUp() {
       wordCount = new WordCount();
    }

    @Test
    public void testWordCountOnlyWords() {
        String text = "Hello friends";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(counter, 2);
    }

    @Test
    public void testWordCountWordsSpecialChar() {
        String text = "He!llo friends3, how are you?";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(counter, 2);
    }
}
