package hiring;

import hiring.input.BasicTextProviderFactory;
import hiring.input.ConsoleTextProvider;
import hiring.input.FileTextProvider;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicTextSupplierFactoryTest {

    @Test
    public void createTextProvider_consoleInput() {
        BasicTextProviderFactory factory = new BasicTextProviderFactory(null);
        TextSupplier textProvider = factory.createTextProvider();

        Assert.assertEquals(ConsoleTextProvider.class, textProvider.getClass());
    }

    @Test
    public void createTextProvider_fileInput() {
        Path filePath = createTestFile();
        BasicTextProviderFactory factory = new BasicTextProviderFactory(filePath);
        TextSupplier textProvider = factory.createTextProvider();

        Assert.assertEquals(FileTextProvider.class, textProvider.getClass());
    }

    @Test
    public void createTextProvider_fileNotFound() {
        Path filePath = Paths.get("random");
        BasicTextProviderFactory factory = new BasicTextProviderFactory(filePath);
        TextSupplier textProvider = factory.createTextProvider();

        Assert.assertEquals(ConsoleTextProvider.class, textProvider.getClass());
    }

    private Path createTestFile() {
        try {
            return Files.createTempFile("text-provider-factory-test", "txt");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
