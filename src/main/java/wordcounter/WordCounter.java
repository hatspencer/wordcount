package wordcounter;

import java.util.Arrays;
import java.util.LinkedHashSet;
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
        return getListFromSentence(sentence).size();
    }

    public int countValidUniqueWords(String sentence) {
        List<String> validWords = getListFromSentence(sentence);
        return new LinkedHashSet<>(validWords).size();
    }

    private List<String> getListFromSentence(String sentence) {
        String cleanedSentence = removeSpecialCharacters(sentence);

        String[] words = cleanedSentence.split("\\s+");
        return Arrays.stream(words)
                .filter(isValidWord())
                .filter(isNoStopword())
                .collect(Collectors.toList());
    }

    private String removeSpecialCharacters(String sentence){
        return sentence.replace(".","")
                .replace(",","")
                .replace("-"," ");
    }


    private Predicate<? super String> isNoStopword() {
        return s -> stopWords.isNoStopword(s);
    }

    private Predicate<String> isValidWord() {
        return w -> w.matches("^[a-zA-Z]+$");
    }
}
