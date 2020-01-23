package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class WordCounterTest {

    public static final List<String> EMPTY_STOPWORDS = Collections.emptyList();
    private final WordCounter wordCounter = new WordCounter(EMPTY_STOPWORDS);

    @Test
    public void expectEmptyStringNotToIncreaseWordCount() {
        String userInputString = "";
        Assertions.assertEquals(0,  wordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectSingleWordToReturnCountOfOne() {
        String userInputString = "Foo";
        Assertions.assertEquals(1,  wordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectWordCountEqualToNumberOfWordsInInputString() {
        String userInputString = "Foo Bar";
        Assertions.assertEquals(2, wordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectSingleWordWithSpecialCharacterToReturnCountOfZero() {
        String userInputString = "Foo$";
        Assertions.assertEquals(0, wordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectWordContainingNumberToReturnZeroCount() {
        String userInputString = "Foo1";
        Assertions.assertEquals(0, wordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectStopwordToBeIgnoredAndWordCountToBeOne() {
        WordCounter wordCounter = new WordCounter(Arrays.asList("Stopword"));
        String userInputString = "Stopword Foo";
        Assertions.assertEquals(1, wordCounter.countWordsInUserInput(userInputString));
    }
}
