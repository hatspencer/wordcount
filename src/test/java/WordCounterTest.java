import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

    private static final Scenario[] testScenarios = {
            new Scenario("word", 1),
            new Scenario("word word", 2),
            new Scenario("word      word            word", 3),
            new Scenario("word$word word", 1),
            new Scenario("123word word word", 2),
            new Scenario("word, word, word", 1),
            new Scenario("word. word. word.", 0),
            new Scenario("word123word word word.", 1)
    };

    @Test
    public void testInputScenarios() {
        for (Scenario testScenario : testScenarios) {
            int actualNumberOfWords = new WordCounter(testScenario.sentence).getNumberOfWords();

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
