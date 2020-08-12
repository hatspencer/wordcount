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

    private boolean checkEquality(String[] s1, String[] s2) {
		if (s1 == s2)
			return true;

		if (s1 == null || s2 == null)
			return false;

		int n = s1.length;
		if (n != s2.length)
			return false;

		for (int i = 0; i < n; i++) {
			if (!s1[i].equals(s2[i]))
				return false;
		}

		return true;
	}
    
    @Test
    public void splitterTest() {
       String[] twoWords = { "aaa", "bbb" };
       assertTrue(checkEquality(Splitter.split("aaa bbb"), twoWords));
        
       String[] emptyInput = {  };
       assertTrue(checkEquality(Splitter.split(""), emptyInput));

       String[] oneWordOneBadword = { "aaa", "bb." };
       assertTrue(checkEquality(Splitter.split("aaa bb."), oneWordOneBadword));

        String[] twoWordsExtraSpaces = { "aaa", "bb" };
        assertTrue(checkEquality(Splitter.split("aaa       bb"), twoWordsExtraSpaces));

        String[] tabDelimiter = { "aaa", "bb" };
        assertTrue(checkEquality(Splitter.split("aaa"+((char)9)+"bb"), tabDelimiter));


    }    

    private void wordCounterTest(String[] array, StopWords stopWords, int wordCount, int unique) {
        Statistic statistic = WordCounter.getWordsCount(array, stopWords);
        Assert.assertEquals(statistic.getWordCount(), wordCount);
        Assert.assertEquals(statistic.getUnique(), unique);
    }

    @Test
    public void wordCounterTests() {
       String[] nullArray = null;
       
       StopWords stopWords = readStopWords();

        wordCounterTest(nullArray, stopWords, 0, 0);
        
        String[] emptyArray = {  };
        wordCounterTest(emptyArray, stopWords, 0, 0);

       String[] twoWords = { "aa", "BB" };
        wordCounterTest(twoWords, stopWords, 2, 2);
       
       String[] towWordsWithOneBad = { "aa", "bb.", "CC" };
        wordCounterTest(towWordsWithOneBad, stopWords, 2, 2);
        
       String[] onlyBadWords = { "aa.", "pavel1marek", "koník" };
        wordCounterTest(onlyBadWords, stopWords, 0, 0);

       String[] textWithStopWords = { "aa.", "pavel1marek", "on", "word", "a" };
        wordCounterTest(textWithStopWords, stopWords, 1, 1);

       String[] onlyStopWords = { "on", "a" };
        wordCounterTest(onlyStopWords, stopWords, 0, 0);

        String[] iteration4Test = { "Humpty-Dumpty", "sat", "on", "a", "all.", "Humpty-Dumpty", "had", "a", "great", "fall." };
        wordCounterTest(iteration4Test, stopWords, 3, 3);

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
    public void fileInputTest() {
        testFileInputCatchException("This is small test", "ThisIsSmallTest.txt");

        testFileInputCatchException("This is multiline test", "ThisIsMultilineTest.txt");

        assertThrows(IOException.class, () -> {
            String a = readFileInput("FileNotExists.txt");
        });
    }

}
