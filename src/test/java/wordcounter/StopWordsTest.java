package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

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
    public void shouldDetectAStopword() throws URISyntaxException {
        File file = getTestFile();
        StopWords sut = new StopWords(file);
        boolean isStopword = sut.isStopword("a");

        Assert.assertTrue(isStopword);
    }

    @Test
    public void shouldDetectNoStopword() throws URISyntaxException {
        File file = getTestFile();
        StopWords sut = new StopWords(file);
        boolean isStopword = sut.isStopword("abc");

        Assert.assertFalse(isStopword);
    }

    @Test
    public void emptyStringShouldNotBeAStopword() throws URISyntaxException {
        File file = getTestFile();
        StopWords sut = new StopWords(file);
        boolean isStopword = sut.isStopword("");

        Assert.assertFalse(isStopword);
    }

    private File getTestFile() throws URISyntaxException {
        return Paths.get(this.getClass().getResource("/stopwords.txt").toURI()).toFile();
    }

}