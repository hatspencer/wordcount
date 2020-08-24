import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWordCount extends AbstractWordCount {

    private BufferedReader input;

    public FileWordCount(String filename) throws IOException {
        super();
        input = new BufferedReader(new FileReader(filename));
    }

    protected BufferedReader getInput() {
        return input;
    }
}
