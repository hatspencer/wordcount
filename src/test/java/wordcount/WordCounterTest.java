package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

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

}
