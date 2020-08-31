import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    public long countValidWords(String input) {
        List<String> wordList = Arrays.asList(sanitizeString(input).split("\\s+"));
        return wordList.stream()
                .filter(word ->  word.matches( "[a-zA-Z]+" ))
                .count();
    }

    public long countValidWords(String input, List<String> stopWords) {
        List<String> wordList = Arrays.asList(sanitizeString(input).split("\\s+"));
        return wordList.stream()
                .filter(word -> !stopWords.contains(word))
                .filter(word -> word.matches("[a-zA-Z]+")).count();
    }

    public long countUniqueWords(String input, List<String> stopWords) {
        List<String> santizedList =  Arrays.asList(sanitizeString(input).split("\\s+")).stream()
                .filter(word -> !stopWords.contains(word))
                .filter(word -> word.matches("[a-zA-Z]+")).collect(Collectors.toList());
        return new HashSet<>(santizedList).size();
    }

    private String sanitizeString(String input) {
        return input.replace(".", "").replace("-", "");
    }
}
