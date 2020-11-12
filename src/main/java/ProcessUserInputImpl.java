import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ProcessUserInputImpl implements ProcessUserInput {

    private static final String DELIMETER = "\\s+";
    private static final Pattern MATCH_PATERN =  Pattern.compile("^[a-zA-z]+");

    public List<String> processUserInput(String input) {
        List<String> wordList = new ArrayList<String>();
        if (input != null) {
            String[] words = input.split(DELIMETER);
            Collections.addAll(wordList, words);
            wordList.removeIf(MATCH_PATERN.asPredicate());
        }
        return wordList;
    }
}
