package hiring.input;

import hiring.TextSupplier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

public class FileTextProvider implements TextSupplier {

    private final Path filePath;

    public FileTextProvider(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void supplyText(Consumer<String> textConsumer) {
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            textConsumer.accept(new String(bytes));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
