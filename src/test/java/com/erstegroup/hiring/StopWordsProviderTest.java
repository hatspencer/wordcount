package com.erstegroup.hiring;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class StopWordsProviderTest {

    private static final String FILE = "C:\\Erste\\wordcount\\src\\test\\Resources\\stopwords.txt";
    private static final List<String> FILE_CONTENT = Arrays.asList("the", "a", "on", "off");

    @Test
    public void readStopWords() throws IOException {
        List<String> stopWords =  StopWordsProvider.readStopWords(FILE);

        assertThat(stopWords, equalTo(FILE_CONTENT));
    }
}
