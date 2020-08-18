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

    @Test
    public void testLoadTextFile() throws FailedInputException {
        String loadedText =  InputHelper.readInputTextFile("mytext.txt");
        Assert.assertEquals("Mary had\n" +
                "a little\n" +
                "lamb\n", loadedText);
    }
}
