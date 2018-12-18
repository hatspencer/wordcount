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
    private static final FileFactory FILE_FACTORY = new FileFactory();

    @Test
    public void readStopWords() throws IOException {
        File file = FILE_FACTORY.getFileFrom("stopwords.txt");

        List<String> stopWords =  StopWordsProvider.readStopWords(file.getPath());

        assertThat(stopWords, equalTo(FILE_CONTENT));
    }

}
