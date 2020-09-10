package hiring;

import hiring.input.ConsoleTextProvider;
import hiring.input.FileTextProvider;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextProviderFactory {

    private final String[] args;

    public TextProviderFactory(String[] args) {
        this.args = args;
    }

    public TextProvider createTextProvider() {
        if (args.length == 0) {
            return new ConsoleTextProvider();
        } else if (args.length == 1) {
            String fileName = args[0];
            Path filePath = Paths.get(fileName);
            if (Files.isReadable(filePath)) {
                return new FileTextProvider(filePath);
            } else {
                System.out.printf("File %s does not exist!\n", fileName);
                return new ConsoleTextProvider();
            }
        } else {
            throw new IllegalArgumentException("Incorrect number of arguments!");
        }
    }
}
