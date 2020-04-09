package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopWordsTest {

    @Test
    public void shouldNotCrashOnNullFile() {
        File file = null;
        StopWords sut = new StopWords(file);
        boolean isStopword = sut.isStopword("a");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void shouldNotCrashOnWrongFile() {
        File file = new File("NonExistingFile.void");
        StopWords sut = new StopWords(file);
        boolean isStopword = sut.isStopword("a");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void shouldDetectAStopword() {
        StopWords sut = new StopWords();
        List<String> stopwords = Arrays.asList("the", "a", "on", "off");
        sut.setStopWords(stopwords);
        boolean isStopword = sut.isStopword("a");

        Assert.assertTrue(isStopword);
    }

    @Test
    public void shouldDetectNoStopword() {
        StopWords sut = new StopWords();
        List<String> stopwords = Arrays.asList("the", "a", "on", "off");
        sut.setStopWords(stopwords);
        boolean isStopword = sut.isStopword("abc");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void emptyStringShouldNotBeAStopword() {
        StopWords sut = new StopWords();
        List<String> stopwords = Arrays.asList("the", "a", "on", "off");
        sut.setStopWords(stopwords);

        boolean isStopword = sut.isStopword("");

        Assert.assertFalse(isStopword);
    }

}