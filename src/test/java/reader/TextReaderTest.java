package reader;

import model.TextAnalysis;
import org.junit.Before;
import org.junit.Test;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TextReaderTest {
    private WordValidator wordValidator;
    private FileReader fileReader;
    private TextReader textReader;

    @Before
    public void initialize() {
        fileReader = new FileReader();
        wordValidator = new WordValidator();

        final WordSplitter wordSplitter = new WordSplitter();
        textReader = new TextReader(wordSplitter, wordValidator);

        wordValidator.setStopWords(new ArrayList<>());
    }

    @Test
    public void testReadAndCount() {
        final String TWO_WORDS_TEXT = "Titus had";
        assertEquals(2, textReader.readTextAndCountWords(TWO_WORDS_TEXT).getTotalWords());

        final String THREE_WORDS_TEXT = "Titus had lamb";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_TEXT).getTotalWords());

        final String THREE_WORDS_WITH_INVALID_WORD = "Titus had lamb lam4";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_WITH_INVALID_WORD).getTotalWords());

        final String THREE_WORDS_WITH_MULTIPLE_SPACES = "Titus                 had   lamb";
        assertEquals(3, textReader.readTextAndCountWords(THREE_WORDS_WITH_MULTIPLE_SPACES).getTotalWords());

        final String TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD = "titus    titus   ruco$la";
        assertEquals(2, textReader.readTextAndCountWords(TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD).getTotalWords());
    }

    @Test
    public void testReadAndCountUnqiue() {
        final String NINE_WORDS_SEVEN_UNIQUE_TEST = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        final TextAnalysis response = textReader.readTextAndCountWords(NINE_WORDS_SEVEN_UNIQUE_TEST);

        assertEquals(10, response.getTotalWords());
        assertEquals(8, response.getTotalUniqueWords());
    }

    @Test
    public void testReadAndCountUnqiueWithStopwordsFile() {
        List<String> stopWords;
        try {
            stopWords = initializeStopWordsAndHandleException();
            wordValidator.setStopWords(stopWords);

            final String NINE_WORDS_SEVEN_UNIQUE_TEST = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
            final TextAnalysis response = textReader.readTextAndCountWords(NINE_WORDS_SEVEN_UNIQUE_TEST);

            assertEquals(7, response.getTotalWords());
            assertEquals(6, response.getTotalUniqueWords());
        } catch (IOException ioException) {
            ioException.printStackTrace();
            fail();
        }
    }

    @Test
    public void testReadCountWithStopwordsFile() {
        List<String> stopWords;
        try {
            stopWords = initializeStopWordsAndHandleException();
            wordValidator.setStopWords(stopWords);

            stopWords.forEach(this::testTextWithStopWordCount);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            fail();
        }
    }

    private void testTextWithStopWordCount(final String stopword) {
        final String STRING_WITH_STOPWORD = "titus    titus   " + stopword;
        assertEquals(2, textReader.readTextAndCountWords(STRING_WITH_STOPWORD).getTotalWords());
    }

    private List<String> initializeStopWordsAndHandleException() throws IOException {
        return fileReader.readFileLines("stopwords.txt");
    }
}
