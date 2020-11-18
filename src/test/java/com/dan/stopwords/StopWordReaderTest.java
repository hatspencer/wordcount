package com.dan.stopwords;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Set;

public class StopWordReaderTest extends TestCase {

    @Test
    public void whenTestfileThenCollectionWithSize4() throws FileNotFoundException {
        StopWordReader stopWordReader = new StopWordReader("src/test/resources/stopwords.txt");
        Set<String> stopWords = stopWordReader.readStopWords();

        assertEquals(4, stopWords.size());
    }

}