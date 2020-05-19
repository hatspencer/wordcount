import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordCounterTest {

    private static final String[] testStopWords = {
            "hello", "test", "java"
    };

    private static final Scenario[] testScenarios = {
            new Scenario("word", 1),
            new Scenario("word word", 2),
            new Scenario("word      word            word", 3),
            new Scenario("word$word word", 1),
            new Scenario("123word word word", 2),
            new Scenario("word, word, word", 1),
            new Scenario("word. word. word.", 0),
            new Scenario("word123word word word.", 1),
            new Scenario("word123word java word word.", 1),
            new Scenario("test word, word, word hello", 1),
            new Scenario("tst word$word word java", 2)
    };

    @Test
    public void testInputScenarios() {
        StopWordsDictionary dictionary = new StopWordsDictionary(Arrays.stream(testStopWords)
                .collect(Collectors.toSet()));

        for (Scenario testScenario : testScenarios) {
            int actualNumberOfWords = new WordCounter(dictionary, testScenario.sentence).getNumberOfWords();

            Assert.assertEquals("Number of words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedNumberOfWords, actualNumberOfWords);
        }
    }

    static class Scenario {
        String sentence;
        int expectedNumberOfWords;

        Scenario(String sentence, int expectedNumberOfWords) {
            this.sentence = sentence;
            this.expectedNumberOfWords = expectedNumberOfWords;
        }
    }
}
