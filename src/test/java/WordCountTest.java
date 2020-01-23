import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WordCountTest {

    @Test
    public void expectEmptyStringNotToIncreaseWordCount() {

        String emptyString = "";
        Assertions.assertEquals(0,  WordCount.countWordsInUserInput(emptyString));
    }

    @Test
    public void expectWordCountEqualToNumberOfWordsInInputString() {

        String userInputString = "Foo Bar";
        Assertions.assertEquals(2, WordCount.countWordsInUserInput(userInputString));
    }

}
