package hiring;

import hiring.WordCounter.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Assert.assertEquals(15, wordCount.getTotal());
        Assert.assertEquals(2, wordCount.getUnique());
    }

    @Test
    public void countWords_testStopWords() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository("a", "alpha", "beta");
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        WordCount wordCount = wordCounter.countWords("alpha alpha a beta a gamma gamma");
        Assert.assertEquals(2, wordCount.getTotal());
        Assert.assertEquals(1, wordCount.getUnique());
    }

    @Test
    public void countWords_averageWordLength() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository();
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        WordCount wordCount = wordCounter.countWords("aaa bbbb ccccc dddddd");
        Assert.assertEquals(4.5, wordCount.getAverageWordLength(), 0.00001);
    }

    @Test
    public void countWords_index() {
        StopWordsRepository stopWordsRepository = mockStopWordsRepository();
        WordCounter wordCounter = new BasicWordCounter(stopWordsRepository);

        WordCount wordCount = wordCounter.countWords("aaa bbb aaa");
        Set<String> expectedIndex = new HashSet<>(Arrays.asList("aaa", "bbb"));
        Assert.assertEquals(expectedIndex, wordCount.getIndex());
    }

    private StopWordsRepository mockStopWordsRepository(String... words) {
        return word -> Arrays.asList(words).contains(word);
    }
}
