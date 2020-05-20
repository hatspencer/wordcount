package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.StopWordHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

public class StopWordHandlerImplTest {

    private  StopwordHandler stopwordHandler = new StopWordHandlerImpl();
    @Test
    public void testGetStopWord() throws IOException {
        List<String> stopWords = stopwordHandler.getStopWords(new StringReader("OneWord" + System.lineSeparator() + "SecondWord and something" ));
        Assert.assertEquals(2, stopWords.size());
        Assert.assertEquals("OneWord", stopWords.get(0));
        Assert.assertEquals("SecondWord", stopWords.get(1));
    }

    @Test
    public void testEmptyLine() throws IOException {
        List<String> stopWords = stopwordHandler.getStopWords(new StringReader("" + System.lineSeparator() + "SecondWord and something" ));
        Assert.assertEquals(1, stopWords.size());
        Assert.assertEquals("SecondWord", stopWords.get(0));
    }

    @Test
    public void testNonAlphabet() throws IOException {
        List<String> stopWords = stopwordHandler.getStopWords(new StringReader("454882" + System.lineSeparator() + "SecondWord and something" ));
        Assert.assertEquals(1, stopWords.size());
        Assert.assertEquals("SecondWord", stopWords.get(0));
    }
}
