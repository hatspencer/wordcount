import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class FooTest {

//            "word" 1
//            "word word" 2
//            "wo2rd" 2
//            "" 0
//            "word Word" 2


    @Test
    public void should_count_words() {
        // given
        final int expectedWordNumber = 1;
        final String testSentence = "word";

        // when
        final String[] words = testSentence.split("[^a-zA-Z]");

        // then
        assertNotNull(words);
        assertEquals(expectedWordNumber, words.length);
    }

}
