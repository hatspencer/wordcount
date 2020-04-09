package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WordCounterTest {

    @Test
    public void shouldCountNoWordInEmptyString(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("");

        Assert.assertEquals(0, actualCount);
    }

    @Test
    public void shouldCountNoWordWhenNoValidWordExist(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("W3dhk KF*");

        Assert.assertEquals(0, actualCount);
    }

    @Test
    public void shouldCountOneWord(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word");

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void shouldCountMoreWords(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word Word");

        Assert.assertEquals(2, actualCount);
    }

    @Test
    public void shouldCountMoreWordsUsingTabs(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word Word");

        Assert.assertEquals(2, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreMoreWhitespaces(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word     Word");

        Assert.assertEquals(2, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreNumbersInWord(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word W0rd");

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void shouldCountMoreWordsAndIgnoreSpecialCharactersInWord(){
        WordCounter sut = new WordCounter();
        int actualCount = sut.countValidWords("Word W$rd");

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void shouldExcludeStopwords() {
        StopWords stopWords = new StopWords(Arrays.asList("the", "a", "on", "off"));
        WordCounter sut = new WordCounter(stopWords);
        int actualCount = sut.countValidWords("Word a");

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void shouldProcessListOfSentences() {
        StopWords stopWords = new StopWords(Arrays.asList("the", "a", "on", "off"));
        WordCounter sut = new WordCounter(stopWords);
        List<String> sentences = Arrays.asList("Mary had", "a little", "lamb");
        int actualCount = sut.countValidWords(sentences);

        Assert.assertEquals(4, actualCount);
    }
}
