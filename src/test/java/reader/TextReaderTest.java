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
        final TextAnalysis textAnalysis1 = textReader.readTextAndCountWords(TWO_WORDS_TEXT);
        assertEquals(2, textAnalysis1.getTotalWords());
        assertEquals(2, textAnalysis1.getTotalUniqueWords());
        assertEquals(0, Double.compare(4.0, textAnalysis1.getAverageWordLength()));

        final String THREE_WORDS_TEXT = "Titus had lamb";
        final TextAnalysis textAnalysis2 = textReader.readTextAndCountWords(THREE_WORDS_TEXT);
        assertEquals(3, textAnalysis2.getTotalWords());
        assertEquals(3, textAnalysis2.getTotalUniqueWords());
        assertEquals(0, Double.compare(4.0, textAnalysis2.getAverageWordLength()));

        final String THREE_WORDS_WITH_INVALID_WORD = "Titus had lamb lam4";
        final TextAnalysis textAnalysis3 = textReader.readTextAndCountWords(THREE_WORDS_WITH_INVALID_WORD);
        assertEquals(3, textAnalysis3.getTotalWords());
        assertEquals(3, textAnalysis3.getTotalUniqueWords());
        assertEquals(0, Double.compare(4.0, textAnalysis3.getAverageWordLength()));

        final String THREE_WORDS_WITH_MULTIPLE_SPACES = "Titus                 had   lamb";
        final TextAnalysis textAnalysis4 = textReader.readTextAndCountWords(THREE_WORDS_WITH_MULTIPLE_SPACES);
        assertEquals(3, textAnalysis4.getTotalWords());
        assertEquals(3, textAnalysis4.getTotalUniqueWords());
        assertEquals(0, Double.compare(4.0, textAnalysis4.getAverageWordLength()));

        final String TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD = "titus    titus   ruco$la";
        final TextAnalysis textAnalysis5 = textReader.readTextAndCountWords(TWO_IDENTICAL_WORDS_WITH_MULTIPLE_SPACES_AND_INVALID_WORD);
        assertEquals(2, textAnalysis5.getTotalWords());
        assertEquals(1, textAnalysis5.getTotalUniqueWords());
        assertEquals(0, Double.compare(5.0, textAnalysis5.getAverageWordLength()));
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

    @Test
    public void testReadCountUnknownWordsWithNoKnownWordsFile() {
        final String STRING_WITH_STOPWORD = "titus    titus   Titus";
        assertEquals(2, textReader.readTextAndCountWords(STRING_WITH_STOPWORD).getNumberOfUnknownWords());
    }

    @Test
    public void testReadCountUnknownWordsWithKnownWordsFile() {
        final List<String> knownWords = fileReader.readFileLines("dict.txt");
        textReader.setKnownWords(knownWords);
        final String STRING_WITH_STOPWORD = "titus dog";
        assertEquals(1, textReader.readTextAndCountWords(STRING_WITH_STOPWORD).getNumberOfUnknownWords());
    }

    private void testTextWithStopWordCount(final String stopword) {
        final String STRING_WITH_STOPWORD = "titus    titus   " + stopword;
        assertEquals(2, textReader.readTextAndCountWords(STRING_WITH_STOPWORD).getTotalWords());
    }

    private List<String> initializeStopWordsAndHandleException() throws IOException {
        return fileReader.readFileLines("stopwords.txt");
    }
}
