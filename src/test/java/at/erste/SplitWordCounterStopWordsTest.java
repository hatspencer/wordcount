package at.erste;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SplitWordCounterStopWordsTest {

    @Test
    public void testStopWords() {
        Integer actualCount = countSentence("The Ballot APPLE word");
        Assert.assertEquals("The count is not invalid " , (Integer) 1,actualCount);
    }

    @Test
    public void testOnlyStopWord() {
        Integer actualCount = countSentence("Ballot");
        Assert.assertEquals("The count is not invalid " , (Integer) 0,actualCount);
    }

    @Test
    public void testSentenceWithStopWordAndMixed() {
        Integer actualCount = countSentence("Ballot are counted in the USA and apple is good");
        Assert.assertEquals("The count is not invalid " , (Integer) 7,actualCount);
    }


    private Integer countSentence(String sentence) {
        SplitWordCounterUtil.setStopWordsProvider(new StopWordsProvider() {
            @Override
            public List<String> getLowerCardStopWords() {
                return Arrays.asList("the", "ballot", "apple");
            }
        });
        return SplitWordCounterUtil.countWords(sentence);
    }

}
