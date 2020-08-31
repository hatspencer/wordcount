import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    public long countValidWords(String input) {
        List<String> wordList = Arrays.asList(input.trim().split("\\s+"));
        return wordList.stream()
                .filter(word ->  word.matches( "[a-zA-Z]+" ))
                .map(word -> word.replace(".", ""))
                .map(word -> word.replace("-", " "))
                .count();
    }

    public long countValidWords(String input, List<String> stopWords) {
        List<String> wordList = Arrays.asList(sanitizeString(input).split("\\s+"));
        return wordList.stream()
                .filter(word -> !stopWords.contains(word))
                .filter(word -> word.matches("[a-zA-Z]+")).count();
    }

    public long countUniqueWords(String input, List<String> stopWords) {
        List<String> wordList = Arrays.asList(sanitizeString(input).split("\\s+"));
        List<String> santizedList =  wordList.stream()
                .filter(word -> !stopWords.contains(word))
                .filter(word -> word.matches("[a-zA-Z]+")).collect(Collectors.toList());
        Set<String> set = new HashSet<>(santizedList);
        return set.size();
    }

    private String sanitizeString(String input) {
        return input.replace(".", "").replace("-", " ");
    }
}
