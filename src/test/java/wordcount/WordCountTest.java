package wordcount;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import wordcount.stopwords.StopWords;

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

    @Test
    public void wordCounterTest() {
       String[] nullArray = null;
       
       StopWords stopWords = new StopWords();
       
       Assert.assertEquals(WordCounter.getWordsCount(nullArray, stopWords), 0);
        
        String[] emptyArray = {  };
       Assert.assertEquals(WordCounter.getWordsCount(emptyArray, stopWords), 0);
       
       String[] twoWords = { "aa", "BB" };
       Assert.assertEquals(WordCounter.getWordsCount(twoWords, stopWords), 2);
       
       String[] towWordsWithOneBad = { "aa", "bb.", "CC" };
       Assert.assertEquals(WordCounter.getWordsCount(towWordsWithOneBad, stopWords), 2);
        
       String[] onlyBadWords = { "aa.", "pavel1marek", "koník" };
       Assert.assertEquals(WordCounter.getWordsCount(onlyBadWords, stopWords), 0);
    }    
    
}
