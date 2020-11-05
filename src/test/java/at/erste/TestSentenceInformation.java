package at.erste;

import at.erste.api.SentenceInformation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testEntryIsSorted() {
        SentenceInformation sentenceInformation = getSentenceInformation("suzan adam blanka david cecil");
        Set<String> countedWords = sentenceInformation.getCountedWords();
        List<String> listStructure = new ArrayList<>(countedWords);
        Assert.assertEquals("The 1st is not adam", listStructure.get(0), "adam");
        Assert.assertEquals("The 2nd is not blanka", listStructure.get(1), "blanka");
        Assert.assertEquals("The 3rd is not cecil", listStructure.get(2), "cecil");
        Assert.assertEquals("The 4th is not david", listStructure.get(3), "david");
        Assert.assertEquals("The 5th is not suzan", listStructure.get(4), "suzan");
    }

    @Test
    public void testExampleIsSorted() {
        SentenceInformation sentenceInformation = getSentenceInformation("Mary had a little lamb");
        Set<String> countedWords = sentenceInformation.getCountedWords();
        List<String> listStructure = new ArrayList<>(countedWords);
        Assert.assertEquals( "had" ,listStructure.get(0));
        Assert.assertEquals( "lamb" ,listStructure.get(1));
        Assert.assertEquals( "little", listStructure.get(2));
        Assert.assertEquals( "Mary", listStructure.get(3));
    }

}
