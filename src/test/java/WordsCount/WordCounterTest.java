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

    @Test
    public void countWordsWithoutBlacklistTest() {
        String[] input = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the"};

        WordCounter wc = new WordCounter();

        assertEquals(4, wc.countWords(input));
    }

    @Test
    public void countUniqueWordsWithoutBlacklistTest() {
        String[] input = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the", "abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb", "the"};

        WordCounter wc = new WordCounter();

        assertEquals(4, wc.countUniqueWords(input));
    }

}
