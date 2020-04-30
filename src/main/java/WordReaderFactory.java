import wordreader.FileWordReader;
import wordreader.UserInputWordReader;
import wordreader.WordReader;

public class WordReaderFactory implements IsWordReaderFactory {

    public WordReaderFactory() {
    }

    @Override
    public WordReader getReader(String[] args) {

        if (args.length == 1) {
            return new FileWordReader(args[0].trim());
        }

        return new UserInputWordReader(); // default

    }
}
