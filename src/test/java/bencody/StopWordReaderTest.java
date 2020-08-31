package bencody;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class StopWordReaderTest {

    @Test
    public void should_read_words_from_file() {
        List<String> strings = StopWordReader.readStopWords();
        assertThat(strings, CoreMatchers.hasItems(
                "the",
                "a",
                "on",
                "off"
        ));
    }
}
