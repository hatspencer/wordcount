package hiring;

import hiring.WordCounter.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BasicWordCounterTest {

    @Test
    public void countWords_emptyStopWords() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository();
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        WordCount wordCount = wordCounter.countWords("word word word");
        Assert.assertEquals(3, wordCount.getTotal());
        Assert.assertEquals(1, wordCount.getUnique());

        wordCount = wordCounter.countWords("word word     word\nword\tword");
        Assert.assertEquals(5, wordCount.getTotal());
        Assert.assertEquals(1, wordCount.getUnique());

        String testText = "word word-word.word,word:word;word_word?word!word\"word(word)word{word}word[word]word$word@";
        wordCount = wordCounter.countWords(testText);
        Assert.assertEquals(16, wordCount.getTotal());
        Assert.assertEquals(1, wordCount.getUnique());
    }

    @Test
    public void countWords_testStopWords() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository("a", "alpha", "beta");
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        WordCount wordCount = wordCounter.countWords("alpha alpha a beta a gamma gamma");
        Assert.assertEquals(2, wordCount.getTotal());
        Assert.assertEquals(1, wordCount.getUnique());
    }

    private StopWordsRepository mockStopWordsRepository(String... words) {
        return word -> Arrays.asList(words).contains(word);
    }
}
