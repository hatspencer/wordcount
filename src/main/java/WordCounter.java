import java.util.Arrays;
import java.util.List;

public class WordCounter {

    long countValidWords(String input) {
        List<String> wordList = Arrays.asList(input.trim().split("\\s+"));
        return wordList.stream().filter(word ->  word.matches( "[a-zA-Z]+" )).count();
    }

    long countValidWords(String input, List<String> stopWords) {
        List<String> wordList = Arrays.asList(input.trim().split("\\s+"));

        return wordList.stream()
                .filter(word ->  stopWords.contains(word))
                .filter(word ->  word.matches( "[a-zA-Z]+" ))
                .count();
    }
}
