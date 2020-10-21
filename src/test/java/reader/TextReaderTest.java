package reader;

import org.junit.Before;
import org.junit.Test;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;

import static org.junit.Assert.assertEquals;

public class TextReaderTest {
    private WordSplitter wordSplitter;
    private WordValidator wordValidator;
    private TextReader textReader;

    @Before
    public void initialize() {
        wordSplitter = new WordSplitter();
        wordValidator = new WordValidator();
        textReader = new TextReader(wordSplitter, wordValidator);
    }

    @Test
    public void testReadAndCount() {
        final String TWO_WORDS_TEXT = "Titus had";
        assertEquals(2, textReader.readTextAndCountWords(TWO_WORDS_TEXT));

        final String THREE_WORDS_TEXT = "Titus had lamb";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_TEXT));

        final String THREE_WORDS_WITH_INVALID_WORD = "Titus had lamb lam4";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_WITH_INVALID_WORD));

        final String THREE_WORDS_WITH_MULTIPLE_SPACES = "Titus                 had   lamb";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_WITH_MULTIPLE_SPACES));

        final String TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD = "titus    titus   ruco$la";
        assertEquals(2, textReader.readTextAndCountWords(TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD));
    }
}
