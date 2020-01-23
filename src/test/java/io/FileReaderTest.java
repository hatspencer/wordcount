package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

public class FileReaderTest {
    private String fileName = "stopwords.txt";

    @Test
    public void expectStopwordsToBeNotNull() throws IOException {
        List<String> stopWords = new FileReader().getStopwords(fileName);
        Assertions.assertNotNull(stopWords);
    }

    @Test
    public void expectGetStopwordsToReturnPopulatedList() throws IOException {
        List<String> expectedStopwordsList = Arrays.asList("the","a","on","off");
        List<String> actualStopWords = new FileReader().getStopwords(fileName);
        Assertions.assertEquals(expectedStopwordsList,actualStopWords);
    }

    @Test
    public void expectNoSuchFileExceptionWhenFileDoesNotExist() {
        Assertions.assertThrows(NoSuchFileException.class, () ->
                new FileReader().getStopwords("foo.txt"));
    }
}
