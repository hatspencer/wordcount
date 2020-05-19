import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounterTest {

    private static final String[] TEST_STOP_WORDS = {
            "hello", "test", "java"
    };

    private static final String[] TEST_INDEX_DICTIONARY = {
            "tst", "a"
    };

    private static final Scenario[] TEST_SCENARIOS = {
            new Scenario("word", 1, 1, 4d, Arrays.asList(new DictionaryWord("word", false))),
            new Scenario("word word", 2, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word      word            word", 3, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word$word word", 1, 1, 4d, Arrays.asList(new DictionaryWord("word", false))),
            new Scenario("123word word word", 2, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word, word, word", 3, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word. word. word.", 3, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word123word word word.", 2, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("word123word java word word.", 2, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("test word, word, word hello", 3, 1, 4d, Arrays.asList(new DictionaryWord("word", false), new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("tst word$word word java", 2, 2, 3.5, Arrays.asList(new DictionaryWord("tst", true), new DictionaryWord("word", false))),
            new Scenario("Humpty-Dumpty test on java wall", 3, 3, 19d/3, Arrays.asList(new DictionaryWord("Humpty-Dumpty", false), new DictionaryWord("on", false), new DictionaryWord("wall", false))),
            new Scenario("tst word$word tst word a word", 5, 3, 3d, Arrays.asList(new DictionaryWord("a", true), new DictionaryWord("tst", true), new DictionaryWord("tst", true), new DictionaryWord("word", false), new DictionaryWord("word", false))),
            new Scenario("java hello tst1", 0, 0, 0, Collections.emptyList()),
            new Scenario("java-hello test", 1, 1, 10d, Arrays.asList(new DictionaryWord("java-hello", false)))
    };

    @Test
    public void testInputScenarios() {
        WordsDictionary stopWordDictionary = new HashWordsDictionary(Arrays.stream(TEST_STOP_WORDS)
                .collect(Collectors.toSet()));

        WordsDictionary indexedWordsDictionary = new HashWordsDictionary(Arrays.stream(TEST_INDEX_DICTIONARY)
                .collect(Collectors.toSet()));

        WordCounter wordCounter = new WordCounter(stopWordDictionary, indexedWordsDictionary, true);
        for (Scenario testScenario : TEST_SCENARIOS) {
            WordCountResult wordCountResult = wordCounter.getNumberOfWords(testScenario.sentence);

            Assert.assertEquals("Number of words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedNumberOfWords, wordCountResult.getNumberOfWords());

            Assert.assertEquals("Number of unique words for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedUniqueNumberOfWords, wordCountResult.getNumberOfUniqueWords());

            Assert.assertEquals("Average word length for sentence: " + testScenario.sentence + " is not equal",
                    testScenario.expectedAverageWordLength, wordCountResult.getAverageWordLength(), 0.0001);

            Assert.assertEquals("Indexed words size for sentence: " + testScenario.sentence,
                    testScenario.expectedIndexedWords.size(),
                    wordCountResult.getIndexedWords().size());

            for (int index = 0; index < testScenario.expectedIndexedWords.size(); index++) {
                Assert.assertEquals(testScenario.expectedIndexedWords.get(index), wordCountResult.getIndexedWords().get(index));
            }

        }
    }

    static class Scenario {
        String sentence;
        int expectedNumberOfWords;
        int expectedUniqueNumberOfWords;
        double expectedAverageWordLength;
        List<DictionaryWord> expectedIndexedWords;

        public Scenario(String sentence, int expectedNumberOfWords, int expectedUniqueNumberOfWords,
                        double expectedAverageWordLength, List<DictionaryWord> expectedIndexedWords)
        {
            this.sentence = sentence;
            this.expectedNumberOfWords = expectedNumberOfWords;
            this.expectedUniqueNumberOfWords = expectedUniqueNumberOfWords;
            this.expectedAverageWordLength = expectedAverageWordLength;
            this.expectedIndexedWords = expectedIndexedWords;
        }
    }
}
