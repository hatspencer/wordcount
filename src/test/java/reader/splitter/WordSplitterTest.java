package reader.splitter;

import org.junit.Before;
import org.junit.Test;
import reader.splitter.WordSplitter;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordSplitterTest {
    private WordSplitter wordSplitter;

    @Before
    public void initialize() {
        wordSplitter = new WordSplitter();
    }

    @Test
    public void testWordSplit() {
        final String THREE_WORDS_TEXT = "May had lamb";
        final List<String> threeWordsTextSplit = wordSplitter.splitTextIntoWords(THREE_WORDS_TEXT);
        assertEquals(3, threeWordsTextSplit.size());

        final String TWO_WORDS_TEXT = "Mary had";
        final List<String> twoWordsTextSplit = wordSplitter.splitTextIntoWords(TWO_WORDS_TEXT);
        assertEquals(2, twoWordsTextSplit.size());

        final String THREE_WORDS_TEXT_WITH_ONE_FALSE_WORDS = "Mary ha$ lamb";
        final List<String> twoWordsWithFalseWordsTextSplit = wordSplitter.splitTextIntoWords(THREE_WORDS_TEXT_WITH_ONE_FALSE_WORDS);
        assertEquals(3, twoWordsWithFalseWordsTextSplit.size());
    }
}
