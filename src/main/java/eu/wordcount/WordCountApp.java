package eu.wordcount;

public class WordCountApp {

    private final WordReader reader;
    private final WordCounter counter;

    public WordCountApp(WordReader reader, WordCounter counter) {
        this.reader = reader;
        this.counter = counter;
    }

    public static void main(String[] args) {
        new WordCountApp(new InputLineWordReader(System.in), new WordCounterImpl())
                .countWords();
    }

    public void countWords() {
        System.out.print("Enter text: ");
        String input = reader.readWords();
        int wordsCount = counter.countWords(input);
        System.out.println(String.format("Number of words: %d", wordsCount));
    }
}
