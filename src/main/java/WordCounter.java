import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class WordCounter {
    private List<String> validWords;

    WordCounter(String input) {
        validWords = new ArrayList<>();
        processInput(input);
    }
    private void processInput(String input) {
        String[] wordsInInput = input.split(" ");
        List<String> invalidWords = Arrays.asList(FileUtils.readWordsFromFile("stopwords.txt"));
        for (String s : wordsInInput) {
            if (!invalidWords.contains(s.toLowerCase()) && s.toLowerCase().matches("[a-z,\\-,.]+")) validWords.add(s);
        }
    }
    int getWordsCountInText() {
        return validWords.size();
    }
    int getUniqueWordsCountInText() {
        return new HashSet<>(validWords).size();
    }
}
