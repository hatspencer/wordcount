import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WordCountTest {

    WordCount wordCount;


    @Before
    public void setUp() {
        Set<String> stopWords = new HashSet<String>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
       wordCount = new WordCount(stopWords);
    }

    @Test
    public void testOnlyWords() {
        String text = "Hello friends";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(2, counter);
    }

    @Test
    public void tesWordsSpecialChar() {
        String text = "He!llo friends3yy, how are you?";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(5, counter);
    }


    @Test
    public void testOnlyWordsWithStop() {
        String text = "A friend of the company";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(3, counter);
    }

    @Test
    public void testWordsWithStopAndSepcialChar() {
        String text = "A friend! of the comp}any";
        int counter = wordCount.countWords(text);
        Assert.assertEquals(4, counter);
    }

    @Test
    public void testWordsLoadedFromFileWithStop() throws FailedInputException {
        int resultCounter = wordCount.countWords(InputHelper.readInputTextFile("mytext.txt"));
        Assert.assertEquals(4, resultCounter);
    }

    @Test
    public void testWordsLoadedFromFileWithSpecialChar() throws FailedInputException {
        int resultCounter = wordCount.countWords(InputHelper.readInputTextFile("mytext_special_char.txt"));
        Assert.assertEquals(9, resultCounter);
    }

    @Test
    public void testWordsLoadedFailed()  {
        Assert.assertThrows(FailedInputException.class, () -> wordCount.countWords(InputHelper.readInputTextFile("mytext_special.txt")));
    }

    @Test
    public void testChooseUserInputWhenNoFile()  {
        Assert.assertThrows(FailedInputException.class, () -> wordCount.countWords(InputHelper.readInputTextFile("mytext_special.txt")));
    }

    @Test
    public void testUniqueWordsWithStop()  {
        String text = "A friend of the company the company";
        int counter = wordCount.countWords(text);
        int uniqueWords = wordCount.getUniqueWords().size();
        Assert.assertEquals(4, counter);
        Assert.assertEquals(3, uniqueWords);
    }

    @Test
    public void testUniqueWordsWithStopAndSpecialChar()  {
        String text = "A frie55yynd of the comp}any the comp}any";
        int counter = wordCount.countWords(text);
        int uniqueWords = wordCount.getUniqueWords().size();
        Assert.assertEquals(5, counter);
        Assert.assertEquals(3, uniqueWords);
    }
}
