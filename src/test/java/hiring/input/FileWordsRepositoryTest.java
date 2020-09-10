package hiring.input;

import hiring.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWordsRepositoryTest {

    @Test
    public void containsWord() {
        String testText = "alpha" + System.lineSeparator() + "beta";
        Path filePath = TestUtils.createTempFile("file-text-provider-test", "txt", testText);

        FileWordsRepository fileWordsRepository = new FileWordsRepository(filePath);

        Assert.assertTrue(fileWordsRepository.containsWord("alpha"));
        Assert.assertTrue(fileWordsRepository.containsWord("beta"));
        Assert.assertFalse(fileWordsRepository.containsWord("gamma"));
    }

    @Test(expected = IllegalStateException.class)
    public void containsWord_fileNotFound() {
        Path filePath = Paths.get("random");
        new FileWordsRepository(filePath);
    }
}
