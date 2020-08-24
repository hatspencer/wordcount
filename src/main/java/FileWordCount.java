import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWordCount extends AbstractWordCount {

    BufferedReader input;

    public FileWordCount(String filename) throws IOException {
        super();
        input = new BufferedReader(new FileReader(filename));
    }

    public int getWordCount() throws IOException {
        return wordCountInList(readAllLines(input));
    }
}
