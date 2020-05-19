import java.util.Arrays;

public class WordCounter {

    private final WordsDictionary dictionary;
    private final String text;

    public WordCounter(WordsDictionary dictionary, String text) {
        this.dictionary = dictionary;
        this.text = text;
    }

    public int getNumberOfWords() {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return (int) Arrays.stream(text.split("\\s+"))
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
        InputTextProvider inputTextProvider;

        if (args.length > 0 && !args[0].isEmpty()) {
            inputTextProvider = new FileInputTextProvider(args[0]);
        } else {
            inputTextProvider = new ConsoleInputTextProvider();
        }

        WordCounter wordCounter = new WordCounter(WordsDictionaryFactory.getInstance(), inputTextProvider.getInput());
        System.out.println("Number of words: " + wordCounter.getNumberOfWords());
    }
}
