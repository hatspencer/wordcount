import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {
    @Test
    public void testWordClassCreation(){
        String wordText = "word";
        boolean isKnown = true;
        Word word = new Word(wordText, isKnown);
        assertEquals(word.getWord(), wordText);
        assertEquals(word.isKnown(), isKnown);
    }
    @Test
    public void testWordClassModification(){
        Word word = new Word("word", true);
        word.setKnown(false);
        word.setWord("not a word");
        assertEquals(word.getWord(), "not a word");
        assertFalse(word.isKnown());
    }
    @Test
    public void testKnownWordSToString(){
        Word word = new Word("word", true);
        String result = word.toString();
        assertEquals("word",result);
    }
    @Test
    public void testUnknownWordSToString(){
        Word word = new Word("word", false);
        String result = word.toString();
        assertEquals("word*",result);
    }

    @Test
    public void testCompatingOfTwoWords(){
        Word testword1 = new Word("word", true);
        Word testword2 = new Word("world", true);
        int result = testword2.compareTo(testword1);
        assertTrue(0<result);
    }
}
