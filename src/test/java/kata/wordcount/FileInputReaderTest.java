package kata.wordcount;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileInputReaderTest {

    @Test
    public void getInput_fileExists() {
        FileInputReader reader = new FileInputReader("src/test/resources/mytext.txt");

        String text = reader.read();

        assertThat(text, is("Mary had\n" +
                "a little\n" +
                "lamb"));

    }

    @Test(expected = IllegalStateException.class)
    public void getInput_fileDoesntExist() {
        new FileInputReader("doesnotexist");
    }
}
