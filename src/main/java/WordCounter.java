import java.util.Arrays;

public class WordCounter {

    private StopWordReader stopWordReader;

    public WordCounter(StopWordReader stopWordReader) {
        this.stopWordReader = stopWordReader;
    }

    public String[] splitText(String text) {
        return text.split(" ");
    }

    public long countWords(String[] words) {
        return Arrays.stream(words)
                .filter(word -> word.matches("[A-Za-z]+"))
                .filter(word -> !stopWordReader.readStopWords().contains(word))
                .count();
    }

}