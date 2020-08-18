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
    public void testOnlyWords() {
        String text = "Hello friends";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(2, counter);
    }

    @Test
    public void tesWordsSpecialChar() {
        String text = "He!llo friends3, how are you?";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(2, counter);
    }


    @Test
    public void testOnlyWordsWithStop() {
        String text = "A friend of the company";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(3, counter);
    }

    @Test
    public void testWordsWithStopAndSepcialChar() {
        String text = "A friend! of the comp}any";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(1, counter);
    }
}
