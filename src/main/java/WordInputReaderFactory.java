import java.io.File;

public class WordInputReaderFactory {

    public WordInputReader create(String[] args) {
        if (args.length > 0) {
            File inputFile = new File(args[0]);
            return new WordInputFileReader(inputFile);
        } else {
            return new WordInputConsoleReader();
        }
    }
}
