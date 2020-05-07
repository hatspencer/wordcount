import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import input.InputReader;
import input.impl.InputReaderImpl;
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

    public static void main(String[] args) {
        OutputWriter outputWriter = initOutputWriter();
        InputReader stdInInputReader = initStdInInputReader();
        TextObtainer textObtainer = initTextObtainer(outputWriter, stdInInputReader);

        WordMatcher wordMatcher = initWordMatcher();
        TextSplitter textSplitter = initTextSplitter();
        WordCounter wordCounter = initWordCounter(Collections.singleton(wordMatcher), textSplitter);

        Main main = new Main(
            outputWriter,
            stdInInputReader,
            textObtainer,
            wordMatcher,
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

    private static TextObtainer initTextObtainer(OutputWriter outputWriter, InputReader inputReader) {
        return new TextObtainerImpl(inputReader, outputWriter);
    }

    private static WordMatcher initWordMatcher() {
        return new AzWordMatcherImpl();
    }

    private static TextSplitter initTextSplitter() {
        return new WhiteSpaceTextSplitterImpl();
    }

    private static WordCounter initWordCounter(Collection<WordMatcher> wordMatchers, TextSplitter textSplitter) {
        return new WordCounterImpl(wordMatchers, textSplitter);
    }

}
