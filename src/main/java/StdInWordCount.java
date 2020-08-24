import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInWordCount extends AbstractWordCount {

    BufferedReader input;

    public StdInWordCount() throws IOException {
        super();
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getWordCount() throws IOException {
        return wordCountInList(readAllLines(input));
    }
}
