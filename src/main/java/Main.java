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

    public static void main(String[] args) {
        OutputWriter outputWriter = initOutputWriter();
        InputReader stdInInputReader = initStdInInputReader();
        TextObtainer textObtainer = initTextObtainer(outputWriter, stdInInputReader);

        String text = textObtainer.obtainText("Enter text: ");

        WordMatcher wordMatcher = initWordMatcher();
        TextSplitter textSplitter = initTextSplitter();
        WordCounter wordCounter = initWordCounter(wordMatcher, textSplitter);

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

    private static WordCounter initWordCounter(WordMatcher wordMatcher, TextSplitter textSplitter) {
        return new WordCounterImpl(wordMatcher, textSplitter);
    }

}
