import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordCounter {

    public long countValidWords(String input) {
        List<String> wordList = Arrays.asList(input.trim().split("\\s+"));
        return wordList.stream().filter(word ->  word.matches( "[a-zA-Z]+" )).count();
    }

    public long countValidWords(String input, List<String> stopWords) {
        List<String> wordList = Arrays.asList(input.trim().split("\\s+"));
        return wordList.stream()
                .filter(word ->  !stopWords.contains(word))
                .filter(word ->  word.matches( "[a-zA-Z]+" ))
                .count();
    }

/*
    private long findUniqueWords(String input) {
        Map<String, Integer> uniqueCount;
        // use map key = word, value = count.
        return 0L;
    }
*/

}
