package wordcounter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    public int countValidWords(String sentence) {

        String[] words = sentence.split("\\s+");
        List<String> validWords = Arrays.stream(words).filter(w -> w.matches("^[a-zA-Z]+$")).collect(Collectors.toList());

        return validWords.size();
    }
}
