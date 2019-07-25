package eu.wordcount;

import eu.wordcount.counter.StoppableWordCounter;
import eu.wordcount.reader.FileStopWordsReader;
import eu.wordcount.reader.InputLineWordReader;
import eu.wordcount.writer.MySystemOutputWriter;

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
                new StoppableWordCounter(new FileStopWordsReader("stopwords.txt")),
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
