import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class WordInputFileReader implements WordInputReader {

    private final File inputFile;

    public WordInputFileReader(File inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public String processInput() {
        try {
            return Files.lines(inputFile.toPath()).collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Invalid file was passed", e);
        }
    }

}
