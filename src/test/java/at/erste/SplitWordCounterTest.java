package at.erste;

import org.junit.Assert;
import org.junit.Test;

public class SplitWordCounterTest {

    @Test
    public void countClassicSentence() {
        Integer actualCount = countSentence("Word word word word");
        Assert.assertEquals("The count is not invalid " , (Integer) 4,actualCount);
    }

    @Test
    public void countSentenceWithMoreSpaces() {
        Integer actualCount = countSentence("Word      word word word");
        Assert.assertEquals("The count is not invalid " , (Integer) 4, actualCount);
    }

    @Test
    public void countEmptySentence() {
        Integer actualCount = countSentence("");
        Assert.assertEquals("The count is not invalid " , (Integer) 0, actualCount);
    }

    @Test
    public void countSentenceWithDigits() {
        Integer actualCount = countSentence("Word word wor23d 12345 1pes8");
        Assert.assertEquals("The count is not invalid " , (Integer) 2, actualCount);
    }

    @Test
    public void countOnlyUpperCaseSentence() {
        Integer actualCount = countSentence("WORD WORD");
        Assert.assertEquals("The count is not invalid " , (Integer) 2, actualCount);
    }

    @Test
    public void countSpecialCharactersSentence() {
        Integer actualCount = countSentence("ěščč řžščř ážýýč ššžč");
        Assert.assertEquals("The count is not invalid " ,  (Integer) 0, actualCount);
    }

    @Test
    public void countMixedSentence() {
        Integer actualCount = countSentence("ěščč WoRd 123        řžščř ážýýč ššžč");
        Assert.assertEquals("The count is not invalid " , (Integer) 1, actualCount);
    }

    @Test
    public void countOnlyDigits() {
        Integer actualCount = countSentence("123 456 789 123 4567 89 ");
        Assert.assertEquals("The count is not invalid " , (Integer) 0, actualCount);
    }


    private Integer countSentence(String sentence) {
        return SplitWordCounterUtil.countWords(sentence);
    }


}
