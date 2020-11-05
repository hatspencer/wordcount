package at.erste;

import at.erste.api.SentenceInformation;
import org.junit.Assert;
import org.junit.Test;

public class TestSentenceInformation extends AbstractWordTest {

    @Test
    public void testSampleSentence() {
        SentenceInformation sentenceInformation = getSentenceInformation("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        Assert.assertEquals("The word count does not match", (Integer) 7,sentenceInformation.getWords());
        Assert.assertEquals("The unique count is not valid", (Integer) 6, sentenceInformation.getUnique());
    }

    @Test
    public void testUnique() {
        SentenceInformation sentenceInformation = getSentenceInformation("Humpty-Dumpty Humpty-Dumpty");
        Assert.assertEquals("The word count does not match", (Integer) 2,sentenceInformation.getWords());
        Assert.assertEquals("The unique count is not valid", (Integer) 1, sentenceInformation.getUnique());
    }

    @Test
    public void testUniqueNotIgnoringCase() {
        SentenceInformation sentenceInformation = getSentenceInformation("TEST test");
        Assert.assertEquals("The word count does not match", (Integer) 2,sentenceInformation.getWords());
        Assert.assertEquals("The unique count is not valid", (Integer) 2, sentenceInformation.getUnique());
    }

    @Test
    public void testAverageCounting() {
        SentenceInformation sentenceInformation = getSentenceInformation("TEST test");
        Assert.assertEquals("The word count does not match", (Integer) 2,sentenceInformation.getWords());
        Assert.assertEquals("The unique count is not valid", (Integer) 2, sentenceInformation.getUnique());
        Assert.assertEquals("The average is not valid", (Double) 4d, sentenceInformation.getAverage());
    }

    @Test
    public void testAverageForSentence() {
        SentenceInformation sentenceInformation = getSentenceInformation("dwerqwr asdfqwer sdafasrqwer asfasdtrqwer");
        Assert.assertEquals("The average is not valid", (Double) 9.5, sentenceInformation.getAverage());
    }

    @Test
    public void testAverageForEmptySentence() {
        SentenceInformation sentenceInformation = getSentenceInformation("");
        Assert.assertEquals("The average is not valid", (Double) 0.0, sentenceInformation.getAverage());
    }

    @Test
    public void testAverageForStopWord() {
        SentenceInformation sentenceInformation = getSentenceInformation("on the a");
        Assert.assertEquals("The average is not valid", (Double) 0.0, sentenceInformation.getAverage());
    }

}
