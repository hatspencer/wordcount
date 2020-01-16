package stopwords;

import org.junit.Assert;
import org.junit.Test;
import processor.StopWordReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StopWordsFileReaderTest {

    private StopWordReader toTest = new StopWordsFileReader();
    private Set<String> controlStopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));


    @Test
    public void testNonemptyFile(){
        Set<String> actualStopWords = toTest.getStopWords("stopwords.txt");
        Assert.assertEquals(controlStopWords, actualStopWords);
    }

    @Test
    public void testEmptyFile(){
        Set<String> actualStopWords = toTest.getStopWords("stopwords_empty.txt");
        Assert.assertEquals(new HashSet<String>(), actualStopWords);
    }

    @Test
    public void testNonExistentFile(){
        Set<String> actualStopWords = toTest.getStopWords("dummy.txt");
        Assert.assertEquals(new HashSet<String>(), actualStopWords);
    }
}
