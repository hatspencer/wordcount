package hiring.input;

import hiring.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTextProviderTest {

    @Test
    public void provideText() {
        String testText = "blabla";
        Path filePath = TestUtils.createTempFile("file-text-provider-test", "txt", testText);
        FileTextProvider fileTextProvider = new FileTextProvider(filePath);

        Assert.assertEquals(testText, fileTextProvider.provideText());
    }

    @Test(expected = IllegalStateException.class)
    public void provideText_fileNotFound() {
        Path filePath = Paths.get("random");
        FileTextProvider fileTextProvider = new FileTextProvider(filePath);
        fileTextProvider.provideText();
    }
}
