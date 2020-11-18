package com.dan.stopwords;

import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StopWordReaderTest {

    @Test
    public void whenTestfileThenCollectionWithSize4() throws IOException {
        StopWordReader stopWordReader = new StopWordReader("src/test/resources/stopwords.txt");
        Set<String> stopWords = stopWordReader.readStopWords();

        assertEquals(4, stopWords.size());
    }

}