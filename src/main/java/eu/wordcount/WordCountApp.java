package eu.wordcount;

public class WordCountApp {

    private final WordReader reader;
    private final WordCounter counter;
    private final MyWriter writer;

    public WordCountApp(WordReader reader, WordCounter counter, MyWriter writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
    }

    public static void main(String[] args) {
        new WordCountApp(
                new InputLineWordReader(System.in),
                new WordCounterImpl(),
                new MySystemOutputWriter(System.out))
                .countWords();
    }

    public void countWords() {
        writer.write("Enter text: ");
        String input = reader.readWords();
        int wordsCount = counter.countWords(input);
        writer.write(String.format("Number of words: %d\n", wordsCount));
    }
}
