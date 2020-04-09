package wordcounter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordCounter {

    private StopWords stopWords;

    public WordCounter() {
        this.stopWords = new StopWords();
    }

    public WordCounter(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    public int countValidWords(String sentence) {

        String[] words = sentence.split("\\s+");
        List<String> validWords = Arrays.stream(words).filter(isValidWord()).filter(isNoStopword()).collect(Collectors.toList());

        return validWords.size();
    }

    private Predicate<? super String> isNoStopword() {
        return s -> stopWords.isNoStopword(s);
    }

    private Predicate<String> isValidWord() {
        return w -> w.matches("^[a-zA-Z]+$");
    }
}
