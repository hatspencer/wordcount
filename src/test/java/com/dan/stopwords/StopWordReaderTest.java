package com.dan.stopwords;

import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopWordReaderTest {

    @Test
    public void when_testFile_then_collectionWithSize4() throws IOException {
        Set<String> stopWords = StopWordReader.readStopWords("stopwords.txt");

        assertEquals(4, stopWords.size());
    }

    @Test
    public void when_invalid_input_then_illegal_argument_exception() {
        try {
            StopWordReader.readStopWords(null);

            assertTrue("An exception was expected!", false);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

}