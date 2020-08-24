import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInWordCount extends AbstractWordCount {

    private BufferedReader input;

    public StdInWordCount(String dictionaryName) throws IOException {
        super(dictionaryName);
        System.out.print("Enter text: ");
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    protected BufferedReader getInput() {
        return input;
    }
}
