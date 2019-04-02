package kata.wordcount;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

    private WordCounter wordCounter = new WordCounter(Arrays.asList("the", "a", "on", "off"));

    @Test
    public void count_inputContainsNoSpecialCharacters() {
        String inputText = "Mary had a little lamb";
        long numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(4L));
    }

    @Test
    public void count_inputContainsNumbersAndSpecialCharacters() {
        String inputText = "Mary had 5 lambs and payed 100 $ for it.";
        long numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(6L));
    }

    @Test
    public void count_inputIsNull() {
        long numberOfWords = wordCounter.count(null);
        assertThat(numberOfWords, is(0L));
    }

    @Test
    public void count_inputIsEmpty() {
        long numberOfWords = wordCounter.count("");
        assertThat(numberOfWords, is(0L));
    }

    @Test
    public void count_inputContainsDotAsSeparator() {
        String inputText = "Mary.had.a.little.lamb";
        long numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(0L));
    }

}
