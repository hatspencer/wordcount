package at.egit.wordcount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class LinesReaderTest {

    private LinesReader linesReader = new LinesReader();

    @Test
    public void whenReadNonEmptyFile_thenReturnAllLinesTest() {
        final String fileName = "stopwords.txt";
        final List<String> expected = Arrays.asList("one", "two", "three");

        final List<String> lines = linesReader.readAllLines(fileName);

        assertEquals(expected, lines);
    }

    @Test
    public void whenEmptyFile_thenReturnEmptyList() {
        final String fileName = "emptyFile.txt";
        final List<String> expected = emptyList();

        final List<String> lines = linesReader.readAllLines(fileName);

        assertEquals(expected, lines);
    }

    @Test
    public void whenNonExistingFile_thenReturnEmptyList() {
        final String fileName = "nonExistingFile.txt";
        final List<String> expected = emptyList();

        final List<String> lines = linesReader.readAllLines(fileName);

        assertEquals(expected, lines);
    }
}
