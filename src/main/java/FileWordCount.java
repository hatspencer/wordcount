import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWordCount extends AbstractWordCount {

    private BufferedReader input;

    public FileWordCount(String filename, String dictionaryName) throws IOException {
        super(dictionaryName);
        input = new BufferedReader(new FileReader(filename));
    }

    protected BufferedReader getInput() {
        return input;
    }
}
