package reader;

import org.junit.Before;
import org.junit.Test;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import utils.FileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TextReaderTest {
    private WordSplitter wordSplitter;
    private WordValidator wordValidator;
    private FileReader fileReader;
    private TextReader textReader;

    @Before
    public void initialize() {
        fileReader = new FileReader();
        wordSplitter = new WordSplitter();
        wordValidator = new WordValidator(fileReader);
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

    @Test
    public void testReadCountWithStopwordsFile() {
        List<String> stopWords = null;
        try {
            stopWords = initializeStopWordsAndHandleException();
            stopWords.forEach(this::testTextWithStopWordCount);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            assertFalse(true);
        }
    }

    private void testTextWithStopWordCount(final String stopword) {
        final String STRING_WITH_STOPWORD = "titus    titus   " + stopword;
        assertEquals(2, textReader.readTextAndCountWords(STRING_WITH_STOPWORD));
    }

    private List<String> initializeStopWordsAndHandleException() throws IOException {
        return fileReader.readFile("stopwords.txt");
    }
}
