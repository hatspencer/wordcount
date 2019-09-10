import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Dictionary {
    private List<String> words;

    Dictionary(String dictionaryFileName) {
        words = new ArrayList<>();
        fillDictionaryFromFile(dictionaryFileName);
    }

    private void fillDictionaryFromFile(String dictionaryFileName) {
        if (dictionaryFileName != null) {
            words = new ArrayList<>(Arrays.asList(FileUtils.readWordsFromFile(dictionaryFileName)));
        } else {
            words = new ArrayList<>();
        }
    }

    boolean hasWord(String word) {
        return words.contains(word);
    }
}
