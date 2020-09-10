package hiring.input;

import hiring.TextProvider;
import hiring.TextProviderFactory;

import java.nio.file.Files;
import java.nio.file.Path;

public class BasicTextProviderFactory implements TextProviderFactory {

    private final Path inputFilePath;

    public BasicTextProviderFactory(Path inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public TextProvider createTextProvider() {
        if (inputFilePath == null) {
            return new ConsoleTextProvider();
        } else if (Files.isReadable(inputFilePath)) {
            return new FileTextProvider(inputFilePath);
        } else {
            System.out.printf("Input file %s does not exist!\n", inputFilePath);
            return new ConsoleTextProvider();
        }
    }
}
