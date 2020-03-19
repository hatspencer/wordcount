package WordsCount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FilterTest {

    @Test
    public void testFilterWithPatternPredicate() {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\-]+$");
        String[] words = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB", "aaa-bbb"};
        String[] expected = new String[]{"abc", "ABC", "aaa-bbb" };

        List<String> result = Filter.filterWords(pattern.asPredicate(), words);

        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testFilterWithStopWordsPredicate() {
        List<String> stopWords = Arrays.asList("the", "a", "off", "on");
        String[] words = new String[]{"abc", "ABC", "123", "ab1", "off", "$$$", "$aB", "$1aB" ,"the"};
        String[] expected = new String[]{"abc", "ABC", "123", "ab1", "$$$", "$aB", "$1aB" };

        List<String> result = Filter.filterWords((word) -> !stopWords.contains(word), words);

        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testFilterUniqueWords() {
        List<String> words = Arrays.asList("aaa", "bbb", "aaa", "bbb");

        Set<String> result = Filter.filterUniqueWords(words);

        assertEquals(2, result.size());
    }

}
