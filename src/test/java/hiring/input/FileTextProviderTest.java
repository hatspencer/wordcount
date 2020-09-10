package hiring.input;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTextProviderTest {

    @Test
    public void provideText() {
        String testText = "blabla";
        Path testFile = createTestFile(testText);
        FileTextProvider fileTextProvider = new FileTextProvider(testFile);

        Assert.assertEquals(testText, fileTextProvider.provideText());
    }

    private Path createTestFile(String content) {
        try {
            Path path = Files.createTempFile("file-text-provider-test", "txt");
            Files.write(path, content.getBytes());
            return path;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
