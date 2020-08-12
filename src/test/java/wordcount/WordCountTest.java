package wordcount;

import org.junit.Assert;

import org.junit.Test;
import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;
import wordcount.wordcounter.Splitter;
import wordcount.wordcounter.Statistic;
import wordcount.wordcounter.WordCounter;
import wordcount.wordcounter.input.Input;
import wordcount.wordcounter.input.InputFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class WordCountTest {

    private StopWords stopWords = readStopWords();

    @Test
    public void splitterTest1() {
        String[] twoWords = {"aaa", "bbb"};
        Assert.assertArrayEquals(Splitter.split("aaa bbb"), twoWords);
    }

    @Test
    public void splitterTest2() {
       String[] emptyInput = {  };
        Assert.assertArrayEquals(Splitter.split(""), emptyInput);
    }

    @Test
    public void splitterTest3() {
        String[] oneWordOneBadword = { "aaa", "bb" };
        Assert.assertArrayEquals(Splitter.split("aaa bb."), oneWordOneBadword);
    }

    @Test
    public void splitterTest4() {
        String[] delimiterWhitespaceAndDot = { "aaa", "bb", "cc" };
        Assert.assertArrayEquals(Splitter.split("aaa. bb.cc."), delimiterWhitespaceAndDot);
    }

    @Test
    public void splitterTest5() {
        String[] twoWordsExtraSpaces = { "aaa", "bb" };
        Assert.assertArrayEquals(Splitter.split("aaa       bb"), twoWordsExtraSpaces);
    }

    @Test
    public void splitterTest6() {
        String[] tabDelimiter = { "aaa", "bb" };
        Assert.assertArrayEquals(Splitter.split("aaa"+((char)9)+"bb"), tabDelimiter);
    }

    private void wordCounterTest(String[] array, StopWords stopWords, int wordCount, int unique) {
        Statistic statistic = WordCounter.getWordsCount(array, stopWords);
        Assert.assertEquals(statistic.getWordCount(), wordCount);
        Assert.assertEquals(statistic.getUnique(), unique);
    }

    @Test
    public void wordCounterTests1() {
        String[] nullArray = null;
        wordCounterTest(nullArray, stopWords, 0, 0);
    }

    @Test
    public void wordCounterTests2() {
        String[] emptyArray = {  };
        wordCounterTest(emptyArray, stopWords, 0, 0);
    }

    @Test
    public void wordCounterTests3() {
        String[] twoWords = { "aa", "BB" };
        wordCounterTest(twoWords, stopWords, 2, 2);
    }

    @Test
    public void wordCounterTests4() {
        String[] towWordsWithOneBad = { "aa", "bb.", "CC" };
        wordCounterTest(towWordsWithOneBad, stopWords, 2, 2);
    }

    @Test
    public void wordCounterTests5() {
        String[] onlyBadWords = { "aa.", "pavel1marek", "koník" };
        wordCounterTest(onlyBadWords, stopWords, 0, 0);
    }

    @Test
    public void wordCounterTests6() {
        String[] textWithStopWords = { "aa.", "pavel1marek", "on", "word", "a" };
    }

    @Test
    public void wordCounterTests7() {
        String[] onlyStopWords = { "on", "a" };
        wordCounterTest(onlyStopWords, stopWords, 0, 0);
    }

    @Test
    public void wordCounterTests8() {
        String[] iteration4Test = { "Humpty", "Dumpty", "sat", "on", "a", "all", "Humpty", "Dumpty", "had", "a", "great", "fall" };
        wordCounterTest(iteration4Test, stopWords, 9, 7);
    }

    @Test
    public void wordCounterTests9() {
        String[] duplicates = { "duplicate", "words", "duplicate", "duplicate", "duplicate" };
        wordCounterTest(duplicates, stopWords, 5, 2);
    }

    private StopWords readStopWords() {
        try {
            StopWords stopWords = new StopWords();
            StopWordsReader stopWordsReader = new StopWordsReader();
            stopWords.setStopWords(stopWordsReader.readWords());
            return stopWords;
        } catch (IOException | URISyntaxException ex) {
            fail("Cannot read file with stopwords");
        }
        return null;
    }


    @Test
    public void stopWordsReaderTest() {
        assertNotNull(readStopWords());
    }

    private String readFileInput(String filename) throws IOException {
        File file = new File(filename);

        Input input = InputFactory.getInput(file.getAbsolutePath());
        return input.getInputData();
    }

    private void testFileInputCatchException(String test, String filename) {
        try {
            Assert.assertEquals(test, readFileInput(filename));
        } catch (IOException e) {
            fail("File "+filename+" is not readable " + e.getLocalizedMessage());
        }
    }

    @Test
    public void fileInputTest1() {
        testFileInputCatchException("This is small test", "ThisIsSmallTest.txt");
    }

    @Test
    public void fileInputTest2() {
        testFileInputCatchException("This is multiline test", "ThisIsMultilineTest.txt");
    }

    @Test
    public void fileInputTest3() {
        testFileInputCatchException("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", "HumptyDumptyTest.txt");
    }

    @Test
    public void fileInputTestNotExistiting() {
        assertThrows(IOException.class, () -> {
            String a = readFileInput("FileNotExists.txt");
        });
    }

    private void testFromInputToStats(String input, int wordCount, int unique, StopWords stopWords) {
        String[] splittedInput = Splitter.split(input);
        wordCounterTest(splittedInput, stopWords, wordCount, unique);
    }

    @Test
    public void testEndToEnd1() {
        testFromInputToStats("Mary had a little lamb", 4, 4, stopWords);
    }

    @Test
    public void testEndToEnd2() {
        testFromInputToStats("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 7, 6, stopWords);
    }

    @Test
    public void testEndToEnd3() {
        testFromInputToStats("S0me we1rd w0rds are in input text. on a I don't know text.", 7, 6, stopWords);
    }

    @Test
    public void testEndToEnd4() {
        testFromInputToStats("this---is-not-a-word this-is-not-a-word thisIsA-Word ok :-)", 2, 2, stopWords);
    }


}
