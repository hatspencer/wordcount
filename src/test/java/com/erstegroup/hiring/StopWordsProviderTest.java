package com.erstegroup.hiring;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StopWordsProviderTest {

    private static final List<String> FILE_CONTENT = Arrays.asList("the", "a", "on", "off");

    @Test
    public void readStopWords() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("stopwords.txt").getFile());
        System.out.println(file.getAbsolutePath());

        List<String> stopWords =  StopWordsProvider.readStopWords(file.getAbsolutePath());

        assertThat(stopWords, equalTo(FILE_CONTENT));
    }
}
