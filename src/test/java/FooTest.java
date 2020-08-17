import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class FooTest {

//            "word" 1
//            "word word" 2
//            "wo2rd" 2
//            "" 0
//            "word Word" 2

    private final String sentence;
    private final int count;

    public FooTest(String sentence, int count) {
        this.sentence = sentence;
        this.count = count;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][]{
                {"word", 1},
                {"word word", 2},
                {"wo2rd", 2},
                {"", 0},
                {"word Word", 2}
        });
    }

    @Test
    public void should_count_words() {
        // given
        final int expectedWordNumber = count;
        final String testSentence = sentence;

        // when
        final String[] words = testSentence.split("[^a-zA-Z]");

        // then
        assertNotNull(words);
        assertEquals(expectedWordNumber, words.length);
    }

}
