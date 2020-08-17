import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SentenceSplitterVTest {

    private final AbstractSentenceSplitter testObject;
    private final String sentence;
    private final long expectedWordsCount;
    private final long expectedUniqueWordsCount;


    public SentenceSplitterVTest(final String sentence, final int expectedWordsCount, final long expectedUniqueWordsCount) {
        this.testObject = new SentenceSplitterV();
        this.sentence = sentence;
        this.expectedWordsCount = expectedWordsCount;
        this.expectedUniqueWordsCount = expectedUniqueWordsCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        // given
        return Arrays.asList(new Object[][]{
                {"Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 7, 6},
                {null, 0, 0}
        });
    }

    @Test
    public void should_count_unique_words_without_hypen() {
        // when
        final WordCounterResult actualCount = testObject.split(sentence);

        // then
        assertEquals(expectedWordsCount, actualCount.getCount());
        assertEquals(expectedUniqueWordsCount, actualCount.getUniqueCount());
    }

}
