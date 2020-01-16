package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounterTest {

    Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));

    @Test
    public void testWithDefaultDelimiters(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(4, toTest.countWords("Mary had a little lamb"));
    }

    @Test
    public void testWithCustomDelimiters(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        toTest.setDelimiters("[\\s.,:]");
        Assert.assertEquals(4, toTest.countWords("Mary:had,a.little lamb"));
    }

    @Test
    public void testSingleWord(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(1, toTest.countWords("Mary"));
    }

    @Test
    public void testEmptyInput(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(0, toTest.countWords(""));
    }

    @Test
    public void testWhitespaceOnlyInput(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(0, toTest.countWords(""));
    }


    @Test
    public void testMultipleWhitespacesInput(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(4, toTest.countWords("Mary    had a     little lamb"));
    }

    @Test
    public void testLeadingTrailingWhitespacesInput(){
        SimpleWordCounter toTest = new SimpleWordCounter(stopWords);
        Assert.assertEquals(4, toTest.countWords("  Mary    had a     little lamb  "));
    }
}
