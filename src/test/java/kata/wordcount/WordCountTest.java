package kata.wordcount;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordCountTest {

    @Test
    public void countWords() {

        String inputText = "Mary had a little lamb";

        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.count(inputText);
        assertThat(numberOfWords, is(5));
    }
}
