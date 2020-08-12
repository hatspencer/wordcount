package wordcount;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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
       String[] s1 = { "aaa", "bbb" };
       assertTrue(checkEquality(Splitter.split("aaa bbb"), s1));
        
       String[] s2 = {  };
       assertTrue(checkEquality(Splitter.split(""), s2));

       String[] s3 = { "aaa", "bb." };
       assertTrue(checkEquality(Splitter.split("aaa bb."), s3));
       

    }    

    @Test
    public void wordCounterTest() {
       String[] s1 = {  };
       Assert.assertEquals(WordCounter.getWordsCount(s1), 0);
       
       String[] s2 = { "aa", "BB" };
       Assert.assertEquals(WordCounter.getWordsCount(s2), 2);
       
       String[] s3 = { "aa", "bb.", "CC" };
       Assert.assertEquals(WordCounter.getWordsCount(s3), 2);
        

    }    
    
}
