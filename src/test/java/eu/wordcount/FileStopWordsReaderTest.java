package eu.wordcount;

import eu.wordcount.reader.CannotReadException;
import eu.wordcount.reader.FileStopWordsReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileStopWordsReaderTest {

    @Test
    public void whenReadWordsIsCalled_thenShouldReturnExpectedWords() {
        FileStopWordsReader underTest = new FileStopWordsReader("stopwords.txt");
        List<String> expected = Arrays.asList("the", "a", "on", "off");
        List<String> actual = underTest.readWords();
        assertEquals("List counts should be same", expected.size(), actual.size());
    }


    @Test(expected = CannotReadException.class)
    public void whenFileDoesNotExist_thenShouldThrowException() {
        FileStopWordsReader underTest = new FileStopWordsReader("nonExistingFile.txt");
        underTest.readWords();
    }
}
