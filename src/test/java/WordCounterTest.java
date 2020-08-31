import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void init() {
        wordCounter = new WordCounter();
    }

    @Test
    public void should_count_0_for_empty_input() {
        int count = wordCounter.countWords("");

        assertThat(count, equalTo(0));
    }

    @Test
    public void should_count_1_for_1_valid_char() {
        int count = wordCounter.countWords("a");

        assertThat(count, equalTo(1));
    }
}
