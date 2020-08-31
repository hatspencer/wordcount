package bencody;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class StopWordReaderTest {

    @Test
    public void should_read_words_from_file() {
        StopWordReader stopWordReader = new StopWordReader();

        List<String> strings = stopWordReader.readStopWords();
        assertThat(strings, CoreMatchers.hasItems(
                "the",
                "a",
                "on",
                "off"
        ));
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_runtime_exception_on_ioexception() {
        StopWordReader stopWordReader = new StopWordReader(ClassLoader.getSystemResource("doesnotexist.txt"));
        stopWordReader.readStopWords();
    }
}
