package at.erste;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStopWordsProviderImpl {

    @Test
    public void testLinesAreLowerCased() {
        StopWordsProviderImpl stopWordsProvider = new StopWordsProviderImpl() {
            @Override
            public List<String> readAllLinesFromFile() {
                return Arrays.asList("APPLE", "BALLOT", "ERste", "MyTest");
            }
        };

        List<String> stopWords = stopWordsProvider.getLowerCardStopWords();

        Assert.assertNotNull(stopWords);
        Assert.assertEquals("The stopwords list has bad size. ", 4, stopWords.size());
        Assert.assertEquals("1st element is not valid ", "apple", stopWords.get(0));
        Assert.assertEquals("2nd element is not valid ", "ballot", stopWords.get(1));
        Assert.assertEquals("3rd element is not valid ", "erste", stopWords.get(2));
        Assert.assertEquals("4th element is not valid ", "mytest", stopWords.get(3));
    }

}
