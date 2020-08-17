import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WordCounter3Test {

    private final WordCounter testObject;
    private final String sentence;
    private final int expectedWordsCount;

    public WordCounter3Test(final String sentence, final int expectedWordsCount) {
        this.testObject = new WordCounter();
        this.sentence = sentence;
        this.expectedWordsCount = expectedWordsCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        // given
        return Arrays.asList(new Object[][]{
                {null, 0}
        });
    }

    @Test
    public void should_() {
        // when
        // then
    }

}
