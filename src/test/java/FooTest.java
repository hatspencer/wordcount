import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FooTest {

    private final Foo testObject;
    private final String sentence;
    private final int expectedWordsCount;

    public FooTest(final String sentence, final int expectedWordsCount) {
        this.testObject = new Foo();
        this.sentence = sentence;
        this.expectedWordsCount = expectedWordsCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        // given
        return Arrays.asList(new Object[][]{
                {"word", 1},
                {"word word", 2},
                {"wo2rd", 2},
                {"", 0},
                {"word Word", 2},
                {null, 0}
        });
    }

    @Test
    public void should_count_words() {
        // when
        final int actualCount = testObject.count(sentence);

        // then
        assertEquals(expectedWordsCount, actualCount);
    }

}