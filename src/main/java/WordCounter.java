import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordCounter {

    private final WordDictionary dictionary;
    private final String sentence;

    public WordCounter(WordDictionary dictionary, String sentence) {
        this.dictionary = dictionary;
        this.sentence = sentence;
    }

    public int getNumberOfWords() {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        return (int) Arrays.stream(sentence.split("\\s+"))
                .filter(this::containsJustLetters)
                .filter(this::isNotStopWord)
                .count();
    }

    private boolean containsJustLetters(String stringToken) {
        return !stringToken.isEmpty() && stringToken.matches("[a-zA-Z]+");
    }

    private boolean isNotStopWord(String word) {
        return !dictionary.containsWord(word);
    }


    public static void main(String[] args) {
        String inputText = null;
        System.out.print("Enter text: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputText = reader.readLine();
        } catch (IOException e) {
            System.err.println("Error during reading input from command line.");
        }

        WordCounter wordCounter = new WordCounter(StopWordsDictionaryFactory.getInstance(), inputText);
        System.out.println("Number of words: " + wordCounter.getNumberOfWords());
    }
}
