import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordCounterTest {

    private static final String[] testStopWords = {
            "hello", "test", "java"
    };

    private static final Scenario[] testScenarios = {
            new Scenario("word", 1, 1),
            new Scenario("word word", 2, 1),
            new Scenario("word      word            word", 3, 1),
            new Scenario("word$word word", 1, 1),
            new Scenario("123word word word", 2, 1),
            new Scenario("word, word, word", 3, 1),
            new Scenario("word. word. word.", 3, 1),
            new Scenario("word123word word word.", 2, 1),
            new Scenario("word123word java word word.", 2, 1),
            new Scenario("test word, word, word hello", 3, 1),
            new Scenario("tst word$word word java", 2, 2),
            new Scenario("Humpty-Dumpty test on java wall", 4, 4),
            new Scenario("tst word$word tst word a word", 5, 3),
            new Scenario("java hello tst1", 0, 0)
    };

    @Test
    public void testInputScenarios() {
        StopWordsDictionary dictionary = new StopWordsDictionary(Arrays.stream(testStopWords)
                .collect(Collectors.toSet()));

        WordCounter wordCounter = new WordCounter(dictionary);
        for (Scenario testScenario : testScenarios) {
            WordCountResult wordCountResult = wordCounter.getNumberOfWords(testScenario.sentence);

            Assert.assertEquals("Number of words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedNumberOfWords, wordCountResult.getNumberOfWords());

            Assert.assertEquals("Number of unique words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedUniqueNumberOfWords, wordCountResult.getNumberOfUniqueWords());
        }
    }

    static class Scenario {
        String sentence;
        int expectedNumberOfWords;
        int expectedUniqueNumberOfWords;

        public Scenario(String sentence, int expectedNumberOfWords, int expectedUniqueNumberOfWords) {
            this.sentence = sentence;
            this.expectedNumberOfWords = expectedNumberOfWords;
            this.expectedUniqueNumberOfWords = expectedUniqueNumberOfWords;
        }
    }
}
