import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import input.InputReader;
import input.WholeInputReader;
import input.impl.InputReaderImpl;
import input.impl.WholeInputReaderImpl;
import output.OutputWriter;
import output.impl.StdOutOutputWriter;
import text.obtain.TextObtainer;
import text.obtain.impl.TextObtainerImpl;
import text.split.TextSplitter;
import text.split.impl.WhiteSpaceTextSplitterImpl;
import word.count.WordCounter;
import word.count.impl.WordCounterImpl;
import word.match.WordMatcher;
import word.match.impl.AzWordMatcherImpl;
import word.match.impl.ExcludeStopWordMatcherImpl;

public class Main {

    private final OutputWriter outputWriter;
    private final InputReader stdInInputReader;
    private final TextObtainer textObtainer;
    private final WordMatcher wordMatcher;
    private final TextSplitter textSplitter;
    private final WordCounter wordCounter;

    public Main(
            OutputWriter outputWriter, InputReader stdInInputReader, TextObtainer textObtainer, WordMatcher wordMatcher,
            TextSplitter textSplitter, WordCounter wordCounter
    ) {
        this.outputWriter = outputWriter;
        this.stdInInputReader = stdInInputReader;
        this.textObtainer = textObtainer;
        this.wordMatcher = wordMatcher;
        this.textSplitter = textSplitter;
        this.wordCounter = wordCounter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        OutputWriter outputWriter = initOutputWriter();
        InputReader stdInInputReader = initStdInInputReader();
        TextObtainer textObtainer = initTextObtainer(outputWriter, stdInInputReader);

        InputReader fileInputReader = initFileInputReader("stopwords.txt");
        WholeInputReader wholeFileInputReader = initWholeInputReader(fileInputReader);
        List<String> stopWords = wholeFileInputReader.readLines();

        WordMatcher excludeStopWordMatcher = initExcludeStopWordMatcher(stopWords);
        WordMatcher azWordMatcher = initAzWordMatcher();
        TextSplitter textSplitter = initTextSplitter();
        WordCounter wordCounter = initWordCounter(Arrays.asList(azWordMatcher, excludeStopWordMatcher), textSplitter);

        Main main = new Main(
            outputWriter,
            stdInInputReader,
            textObtainer,
            azWordMatcher,
            textSplitter,
            wordCounter
        );

        main.run();
    }

    public void run() {
        String text = textObtainer.obtainText("Enter text: ");
        long wordCount = wordCounter.count(text);
        outputWriter.write("Number of words: ");
        outputWriter.write(String.valueOf(wordCount));
    }

    private static OutputWriter initOutputWriter() {
        return new StdOutOutputWriter();
    }

    private static InputReader initStdInInputReader() {
        return new InputReaderImpl(new Scanner(System.in));
    }

    private static InputReader initFileInputReader(String fileName) throws FileNotFoundException {
        return new InputReaderImpl(new Scanner(new FileInputStream(fileName)));
    }

    private static WholeInputReader initWholeInputReader(InputReader inputReader) {
        return new WholeInputReaderImpl(inputReader);
    }

    private static TextObtainer initTextObtainer(OutputWriter outputWriter, InputReader inputReader) {
        return new TextObtainerImpl(inputReader, outputWriter);
    }

    private static WordMatcher initAzWordMatcher() {
        return new AzWordMatcherImpl();
    }

    private static WordMatcher initExcludeStopWordMatcher(List<String> stopWords) {
        return new ExcludeStopWordMatcherImpl(stopWords);
    }

    private static TextSplitter initTextSplitter() {
        return new WhiteSpaceTextSplitterImpl();
    }

    private static WordCounter initWordCounter(Collection<WordMatcher> wordMatchers, TextSplitter textSplitter) {
        return new WordCounterImpl(wordMatchers, textSplitter);
    }

}
