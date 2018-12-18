import java.util.Arrays;

class WordCounter {

    long countWords(String[] words) {
        return Arrays.stream(words)
                .filter(it -> !it.isEmpty())
                .count();
    }
}
