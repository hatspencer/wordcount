package kata.wordcount;

import java.util.List;

public class WordCountApp {

    private WordCounter wordCounter;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public WordCountApp() {
        this(new ConsoleInputReader());
    }

    public WordCountApp(InputReader inputReader) {
        this(inputReader, new OutputWriter(), new StopwordsLoader());
    }

    public WordCountApp(InputReader inputReader, OutputWriter outputWriter, StopwordsLoader stopwordsLoader) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        List<String> stopwords = stopwordsLoader.loadStopwords();
        wordCounter = new WordCounter(stopwords);
    }

    public static void main(String[] args) {
        InputReader inputReader = createInputReader(args);
        WordCountApp app = new WordCountApp(inputReader);
        app.count();
    }

    static InputReader createInputReader(String[] args) {
        InputReader inputReader;
        if (args.length > 0) {
            String textFileInput = args[0];
            inputReader = new FileInputReader(textFileInput);
        } else {
            inputReader = new ConsoleInputReader();
        }
        return inputReader;
    }

    void count() {
        String inputText = inputReader.read();
        long numberOfWords = wordCounter.count(inputText);
        outputWriter.writeOutput(numberOfWords);
    }

}
