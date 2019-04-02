package kata.wordcount;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

    @Test
    public void count_inputContainsNoSpecialCharacters() {

        String inputText = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        long numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(5L));
    }

    @Test
    public void count_inputContainsNumbersAndSpecialCharacters() {

        String inputText = "Mary had 5 lambs and payed 100 $ for it.";

        WordCounter wordCounter = new WordCounter();
        long numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(6L));
    }
}
