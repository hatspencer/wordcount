import java.util.Arrays;

public class WordCounter {

    public String[] splitText(String text) {
        return text.split(" ");
    }

    public long countWords(String[] words) {
        return Arrays.stream(words).filter(word -> word.matches("[A-Za-z]+")).count();
    }
}