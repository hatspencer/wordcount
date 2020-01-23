package wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WordCountTest {

    @Test
    public void expectEmptyStringNotToIncreaseWordCount() {
        String userInputString = "";
        Assertions.assertEquals(0,  WordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectSingleWordToReturnCountOfOne() {
        String userInputString = "Foo";
        Assertions.assertEquals(1,  WordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectWordCountEqualToNumberOfWordsInInputString() {
        String userInputString = "Foo Bar";
        Assertions.assertEquals(2, WordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectSingleWordWithSpecialCharacterToReturnCountOfZero() {
        String userInputString = "Foo$";
        Assertions.assertEquals(0, WordCounter.countWordsInUserInput(userInputString));
    }

    @Test
    public void expectWordContainingNumberToReturnZeroCount() {
        String userInputString = "Foo1";
        Assertions.assertEquals(0, WordCounter.countWordsInUserInput(userInputString));
    }

}
