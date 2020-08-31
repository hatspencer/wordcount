import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("");

        assertThat(statistics.totalCount, equalTo(0));
        assertThat(statistics.uniqueCount, equalTo(0));
        assertThat(statistics.averageWordLength, equalTo(0.0));
    }

    @Test
    public void should_count_1_for_1_non_stopword_char() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("b");

        assertThat(statistics.totalCount, equalTo(1));
        assertThat(statistics.uniqueCount, equalTo(1));
        assertThat(statistics.averageWordLength, equalTo(1.0));
    }

    @Test
    public void should_count_1_for_hyphenated_non_stopword_chars() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("Humpty-Dumpty");

        assertThat(statistics.totalCount, equalTo(1));
        assertThat(statistics.uniqueCount, equalTo(1));
        assertThat(statistics.averageWordLength, equalTo(13.0));
    }

    @Test
    public void should_count_0_for_1_stopword() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("a");

        assertThat(statistics.totalCount, equalTo(0));
        assertThat(statistics.uniqueCount, equalTo(0));
        assertThat(statistics.averageWordLength, equalTo(0.0));
    }

    @Test
    public void should_count_0_for_1_invalid_char() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("ä");

        assertThat(statistics.totalCount, equalTo(0));
        assertThat(statistics.uniqueCount, equalTo(0));
        assertThat(statistics.averageWordLength, equalTo(0.0));
    }

    @Test
    public void should_not_count_stopwords() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("Mary had a little lamb");

        assertThat(statistics.totalCount, equalTo(4));
        assertThat(statistics.uniqueCount, equalTo(4));
        assertThat(statistics.averageWordLength, equalTo(4.25)); // (4+3+6+4)/4 = 17/4
    }

    @Test
    public void should_count_unique_words() {
        WordCounter.WordCountStatistics statistics = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");

        assertThat(statistics.totalCount, equalTo(7));
        assertThat(statistics.uniqueCount, equalTo(6));
        assertThat(statistics.averageWordLength, equalTo(45d/7));  // (13+3+4+13+3+5+4)/7 = 45/7
    }
}
