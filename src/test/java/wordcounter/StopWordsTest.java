package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class StopWordsTest {

    @Test
    public void shouldNotCrashOnEmptyFilename() {
        StopWords sut = new StopWords("");
        boolean isStopword = sut.isStopword("a");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void shouldNotCrashOnWrongFile() {
        StopWords sut = new StopWords("NonExistingFile.void");
        boolean isStopword = sut.isStopword("a");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void shouldDetectAStopwordFromAFile() {
        StopWords sut = new StopWords("stopwords.txt");
        boolean isStopword = sut.isStopword("a");

        Assert.assertTrue(isStopword);
    }

    @Test
    public void shouldDetectAStopword() {
        StopWords sut = new StopWords(Arrays.asList("the", "a", "on", "off"));
        boolean isStopword = sut.isStopword("a");

        Assert.assertTrue(isStopword);
    }

    @Test
    public void shouldDetectNoStopword() {
        StopWords sut = new StopWords(Arrays.asList("the", "a", "on", "off"));
        boolean isStopword = sut.isStopword("abc");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void emptyStringShouldNotBeAStopword() {
        StopWords sut = new StopWords(Arrays.asList("the", "a", "on", "off"));

        boolean isStopword = sut.isStopword("");

        Assert.assertFalse(isStopword);
    }

}