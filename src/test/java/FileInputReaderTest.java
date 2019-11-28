import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileInputReaderTest {

    @Test
    public void readInputShouldOpenFile() throws Exception {

        FileInputReader fileInputReader = new FileInputReader(getStopWordsPath());
        fileInputReader.readInput();
    }


    @Test
    public void readInputShouldReadFile() throws Exception {
        FileInputReader fileInputReader = new FileInputReader(getStopWordsPath());
        String result = fileInputReader.readInput();

        assertEquals("hello\nworld\nerste", result);
    }

    private static String getStopWordsPath() throws IOException {
        String current = new java.io.File( "." ).getCanonicalPath();

        return current + "/src/test/resources/stopwords.txt";
    }
}