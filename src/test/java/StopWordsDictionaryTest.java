import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StopWordsDictionaryTest {

    private static final List<String> testStopWords = Arrays.asList("car", "coffee", "java");
    private static final HashWordsDictionary dictionary = new HashWordsDictionary(new HashSet<>(testStopWords));

    @Test
    public void testContainsExistingWords() {
        for (String testStopWord : testStopWords) {
            Assert.assertTrue("Dictionary should contain word: " + testStopWord, dictionary.containsWord(testStopWord));
        }
    }

    @Test
    public void testThatItDoesNotContainNonPresentWords() {
        String[] words = {"carr", "coffe", null};

        for (String word : words) {
            Assert.assertFalse("Dictionary should not contain word " + word, dictionary.containsWord(word));
        }
    }
}
