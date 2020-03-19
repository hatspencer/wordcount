package WordsCount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void countWordsTest() {
        String[] input = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the"};
        List<String> blackList = Arrays.asList("the", "a", "off", "on");

        WordCounter wc = new WordCounter(blackList);

        assertEquals(3, wc.countWords(input));

    }

    @Test
    public void countUniqueWordsTest() {
        String[] input = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the", "abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the"};
        List<String> blackList = Arrays.asList("the", "a", "off", "on");

        WordCounter wc = new WordCounter(blackList);

        assertEquals(3, wc.countUniqueWords(input));

    }

}
