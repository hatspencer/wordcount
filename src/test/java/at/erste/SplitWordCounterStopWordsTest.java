package at.erste;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class SplitWordCounterStopWordsTest extends AbstractWordTest {

    @Test
    public void testStopWords() {
        Integer actualCount = countSentence("The on a word");
        Assert.assertEquals("The count is not invalid " , (Integer) 1,actualCount);
    }

    @Test
    public void testOnlyStopWord() {
        Integer actualCount = countSentence("on");
        Assert.assertEquals("The count is not invalid " , (Integer) 0,actualCount);
    }

    @Test
    public void testSentenceWithStopWordAndMixed() {
        Integer actualCount = countSentence("on are counted in the a and apple is good");
        Assert.assertEquals("The count is not invalid " , (Integer) 7,actualCount);
    }



    @Test
    public void testSentenceForIteration4() {
        Integer actualCount = countSentence("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        Assert.assertEquals("The count is not invalid " , (Integer) 7,actualCount);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotExistingFile() {
        StopWordsProviderImpl stopWordsProvider = new StopWordsProviderImpl();
        stopWordsProvider.setFilename(UUID.randomUUID() + ".txt");
        stopWordsProvider.readAllLinesFromFile();
    }





}
