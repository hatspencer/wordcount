package kata.wordcount;

import java.util.List;

public class WordCountApp {

    private WordCounter wordCounter;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public WordCountApp() {
        this(new InputReader(), new OutputWriter(), new StopwordsLoader());
    }

    public WordCountApp(InputReader inputReader, OutputWriter outputWriter, StopwordsLoader stopwordsLoader) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        List<String> stopwords = stopwordsLoader.loadStopwords();
        wordCounter = new WordCounter(stopwords);
    }

    public static void main(String[] args) {
        WordCountApp app = new WordCountApp();
        app.count();
    }

    void count() {
        String inputText = inputReader.getInput();
        long numberOfWords = wordCounter.count(inputText);
        outputWriter.writeOutput(numberOfWords);
    }

}
