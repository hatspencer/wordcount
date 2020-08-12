package wordcount;

import org.junit.Assert;

import org.junit.Test;
import wordcount.properties.PropertiesFactory;
import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;
import wordcount.wordcounter.Splitter;
import wordcount.wordcounter.WordCounter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class WordCountTest {

    private final String STOPWORDS_FILE_FOR_TEST = "classpath:stopwords-for-tests.txt";
    
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

    @Test
    public void wordCounterTest() {
       String[] nullArray = null;
       
       StopWords stopWords = readStopWords(STOPWORDS_FILE_FOR_TEST);
       
       Assert.assertEquals(WordCounter.getWordsCount(nullArray, stopWords), 0);
        
        String[] emptyArray = {  };
       Assert.assertEquals(WordCounter.getWordsCount(emptyArray, stopWords), 0);

       String[] twoWords = { "aa", "BB" };
       Assert.assertEquals(WordCounter.getWordsCount(twoWords, stopWords), 2);
       
       String[] towWordsWithOneBad = { "aa", "bb.", "CC" };
       Assert.assertEquals(WordCounter.getWordsCount(towWordsWithOneBad, stopWords), 2);
        
       String[] onlyBadWords = { "aa.", "pavel1marek", "koník" };
       Assert.assertEquals(WordCounter.getWordsCount(onlyBadWords, stopWords), 0);

       String[] textWithStopWords = { "aa.", "pavel1marek", "on", "word", "a" };
       Assert.assertEquals(WordCounter.getWordsCount(textWithStopWords, stopWords), 1);

       String[] onlyStopWords = { "on", "a" };
       Assert.assertEquals(WordCounter.getWordsCount(onlyStopWords, stopWords), 0);

    }

    private StopWords readStopWords(String filename) {
        Path path = Paths.get(filename);

        try {
            StopWords stopWords = new StopWords();
            stopWords.setStopWords(StopWordsReader.readWords(path));
            return stopWords;
        } catch (IOException ex) {
            fail("Cannot read file "+filename);
        }
        return null;
    }


    @Test
    public void stopWordsReaderTest() {
        Path path = Paths.get("stopwords-not-exists.txt");
        assertThrows(IOException.class, () -> {
            StopWordsReader.readWords(path);
        });

        assertNotNull(readStopWords(STOPWORDS_FILE_FOR_TEST));
    }

    @Test
    public void propertiesReaderTest() {
        try {
            assertNotNull(PropertiesFactory.getPropertiesReader());
        } catch (IOException e) {
            fail("PropertiesReader IOException "+e.getLocalizedMessage());
        }
    }
}
