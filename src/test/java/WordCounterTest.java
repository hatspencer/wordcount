import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounter(Arrays.asList("the", "a", "on", "off"));
    }

    @Test
    public void should_count_0_for_empty_input() {
        int count = wordCounter.countWords("");

        assertThat(count, equalTo(0));
    }

    @Test
    public void should_count_1_for_1_non_stopword_char() {
        int count = wordCounter.countWords("b");

        assertThat(count, equalTo(1));
    }

    @Test
    public void should_count_0_for_1_stopword() {
        int count = wordCounter.countWords("a");

        assertThat(count, equalTo(0));
    }

    @Test
    public void should_count_0_for_1_invalid_char() {
        int count = wordCounter.countWords("ä");

        assertThat(count, equalTo(0));
    }

    @Test
    public void should_not_count_stopwords() {
        int count = wordCounter.countWords("Mary had a little lamb");

        assertThat(count, equalTo(4));
    }
}
