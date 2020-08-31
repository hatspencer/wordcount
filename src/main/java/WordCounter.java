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

    public double calculateTheAverage(String input, List<String> stopWords) {
        List<String> santizedList = Arrays.asList(sanitizeString(input).split("\\s+")).stream()
                .filter(word -> !stopWords.contains(word))
                .filter(word -> word.matches("[a-zA-Z]+")).collect(Collectors.toList());
        int sum = santizedList.stream().mapToInt(word-> word.length()).sum();
        if(santizedList.size() > 0) {
            return sum * 1.0 / santizedList.size();
        }
        return 0.0;
    }

    private String sanitizeString(String input) {
        return input.replace(".", "").replace("-", "");
    }
}
