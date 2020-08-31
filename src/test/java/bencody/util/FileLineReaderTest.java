package bencody.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class FileLineReaderTest {

    @Test
    public void should_read_lines_from_existing_file() {
        List<String> strings = FileLineReader.readLines(ClassLoader.getSystemResource("stopwords.txt"));
        assertThat(strings, CoreMatchers.hasItems(
                "the",
                "a",
                "on",
                "off"
        ));
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_runtime_exception_on_ioexception() {
        FileLineReader.readLines(ClassLoader.getSystemResource("doesnotexist.txt"));
    }
}
