import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounterTest {

    private static final String[] testStopWords = {
            "hello", "test", "java"
    };

    private static final Scenario[] testScenarios = {
            new Scenario("word", 1, 1, 4d, Collections.singletonList("word")),
            new Scenario("word word", 2, 1, 4d, Arrays.asList("word", "word")),
            new Scenario("word      word            word", 3, 1, 4d, Arrays.asList("word", "word", "word")),
            new Scenario("word$word word", 1, 1, 4d, Collections.singletonList("word")),
            new Scenario("123word word word", 2, 1, 4d, Arrays.asList("word", "word")),
            new Scenario("word, word, word", 3, 1, 4d, Arrays.asList("word", "word", "word")),
            new Scenario("word. word. word.", 3, 1, 4d, Arrays.asList("word", "word", "word")),
            new Scenario("word123word word word.", 2, 1, 4d, Arrays.asList("word", "word")),
            new Scenario("word123word java word word.", 2, 1, 4d, Arrays.asList("word", "word")),
            new Scenario("test word, word, word hello", 3, 1, 4d, Arrays.asList("word", "word", "word")),
            new Scenario("tst word$word word java", 2, 2, 3.5, Arrays.asList("tst", "word")),
            new Scenario("Humpty-Dumpty test on java wall", 3, 3, 19d/3, Arrays.asList("Humpty-Dumpty", "on", "wall")),
            new Scenario("tst word$word tst word a word", 5, 3, 3d, Arrays.asList("a", "tst", "tst", "word", "word")),
            new Scenario("java hello tst1", 0, 0, 0, Collections.emptyList()),
            new Scenario("java-hello test", 1, 1, 10d, Collections.singletonList("java-hello"))
    };

    @Test
    public void testInputScenarios() {
        StopWordsDictionary dictionary = new StopWordsDictionary(Arrays.stream(testStopWords)
                .collect(Collectors.toSet()));

        WordCounter wordCounter = new WordCounter(dictionary, true);
        for (Scenario testScenario : testScenarios) {
            WordCountResult wordCountResult = wordCounter.getNumberOfWords(testScenario.sentence);

            Assert.assertEquals("Number of words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedNumberOfWords, wordCountResult.getNumberOfWords());

            Assert.assertEquals("Number of unique words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedUniqueNumberOfWords, wordCountResult.getNumberOfUniqueWords());

            Assert.assertEquals("Average word length for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedAverageWordLength, wordCountResult.getAverageWordLength(), 0.0001);

            Assert.assertEquals("Indexed words for sentence: " + testScenario.sentence,
                    testScenario.expectedIndexedWords, wordCountResult.getIndexedWords());
        }
    }

    static class Scenario {
        String sentence;
        int expectedNumberOfWords;
        int expectedUniqueNumberOfWords;
        double expectedAverageWordLength;
        List<String> expectedIndexedWords;

        public Scenario(String sentence, int expectedNumberOfWords, int expectedUniqueNumberOfWords,
                        double expectedAverageWordLength, List<String> expectedIndexedWords)
        {
            this.sentence = sentence;
            this.expectedNumberOfWords = expectedNumberOfWords;
            this.expectedUniqueNumberOfWords = expectedUniqueNumberOfWords;
            this.expectedAverageWordLength = expectedAverageWordLength;
            this.expectedIndexedWords = expectedIndexedWords;
        }
    }
}
