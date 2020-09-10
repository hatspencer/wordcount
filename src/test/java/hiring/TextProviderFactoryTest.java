package hiring;

import hiring.input.ConsoleTextProvider;
import hiring.input.FileTextProvider;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextProviderFactoryTest {

    @Test
    public void createTextProvider_consoleInput() {
        String[] args = new String[]{};
        TextProviderFactory factory = new TextProviderFactory(args);
        TextProvider textProvider = factory.createTextProvider();

        Assert.assertEquals(ConsoleTextProvider.class, textProvider.getClass());
    }

    @Test
    public void createTextProvider_fileInput() {
        Path filePath = createTestFile();
        String[] args = new String[]{filePath.toString()};
        TextProviderFactory factory = new TextProviderFactory(args);
        TextProvider textProvider = factory.createTextProvider();

        Assert.assertEquals(FileTextProvider.class, textProvider.getClass());
    }

    @Test
    public void createTextProvider_fileNotFound() {
        String[] args = new String[]{"random"};
        TextProviderFactory factory = new TextProviderFactory(args);
        TextProvider textProvider = factory.createTextProvider();

        Assert.assertEquals(ConsoleTextProvider.class, textProvider.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTextProvider_illegalNumberOfArguments() {
        String[] args = new String[]{"first", "second"};
        TextProviderFactory factory = new TextProviderFactory(args);
        factory.createTextProvider();
    }

    private Path createTestFile() {
        try {
            return Files.createTempFile("text-provider-factory-test", "txt");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
