package cz.rleifer.test.wordcounter.core;

import org.junit.Assert;
import org.junit.Test;

import java.io.StringReader;

public class StopWordHandlerImplTest {

    @Test
    public void testGetStopWord(){
        StopwordHandler stopwordHandler = new StopwordHandlerImpl(new StringReader("OneWord" + System.lineSeparator() + "SecondWord and something" ));
        String[] stopWords = stopwordHandler.getStopWords();
        Assert.assertEquals(2, stopWords.length);
        Assert.assertEquals("OneWord", stopWords[0]);
        Assert.assertEquals("SecondWord", stopWords[1]);

    }
}
