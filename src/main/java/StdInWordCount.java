import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StdInWordCount extends AbstractWordCount {

    private final List<String> input;

    public StdInWordCount(List<String> input, String dictionaryName) throws IOException {
        super(dictionaryName);
        this.input = input;
    }

    protected List<String> getInput() {
        return input;
    }
}
