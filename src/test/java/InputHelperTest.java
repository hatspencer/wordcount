import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class InputHelperTest {


    @Before
    public void setUp() {

    }

    @Test
    public void testLoadStopWords() throws FailedInputException {
        Set<String> resultStopWords =  InputHelper.setStopWords();
        Set<String> stopWords = new HashSet<String>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
        Assert.assertEquals(stopWords, resultStopWords);
    }

  /*  @Test
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
    }*/
}