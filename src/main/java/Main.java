import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import input.InputReader;
import input.impl.OneLineInputReaderImpl;
import input.impl.WholeInputReaderImpl;
import output.OutputWriter;
import output.impl.StdOutOutputWriter;
import text.obtain.TextObtainer;
import text.obtain.impl.TextObtainerImpl;
import text.obtain.impl.TextObtainerWithIntroTextImpl;
import text.split.TextSplitter;
import text.split.impl.WhiteSpaceTextSplitterImpl;
import word.count.WordCounter;
import word.count.impl.WordCounterImpl;
import word.match.WordMatcher;
import word.match.impl.AzWordMatcherImpl;
import word.match.impl.ExcludeStopWordMatcherImpl;

public class Main {

    private final OutputWriter resultOutputWriter;
    private final TextObtainer inputTextObtainer;
    private final WordCounter wordCounter;

    public Main(OutputWriter resultOutputWriter, TextObtainer inputTextObtainer, WordCounter wordCounter) {
        this.resultOutputWriter = resultOutputWriter;
        this.inputTextObtainer = inputTextObtainer;
        this.wordCounter = wordCounter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        TextObtainer inputTextObtainer = initTextObtainerBasedOnArguments(args);
        OutputWriter resultOutputWriter = new StdOutOutputWriter();
        WordCounter wordCounter = initWordCounter("stopwords.txt");

        Main main = new Main(resultOutputWriter, inputTextObtainer, wordCounter);
        main.run();
    }

    public void run() {
        String text = inputTextObtainer.obtainText();
        long wordCount = wordCounter.count(text);
        resultOutputWriter.write("Number of words: ");
        resultOutputWriter.write(String.valueOf(wordCount));
    }

    private static TextObtainer initTextObtainerBasedOnArguments(String[] args) throws FileNotFoundException {
        return args.length > 0 ? initTextObtainerForFile(args[0]) : initTextObtainerForStdIn();
    }

    private static TextObtainer initTextObtainerForFile(String fileName) throws FileNotFoundException {
        InputReader fileInputReader = initFileInputReader(fileName);
        return new TextObtainerImpl(fileInputReader);
    }

    private static TextObtainer initTextObtainerForStdIn() {
        OutputWriter stdOutOutputWriter = new StdOutOutputWriter();
        InputReader stdInInputReader = initStdInInputReader();
        return new TextObtainerWithIntroTextImpl(stdInInputReader, stdOutOutputWriter, "Enter text: ");
    }

    private static InputReader initFileInputReader(String fileName) throws FileNotFoundException {
        return new WholeInputReaderImpl(new Scanner(new FileInputStream(fileName)));
    }

    private static InputReader initStdInInputReader() {
        return new OneLineInputReaderImpl(new Scanner(System.in));
    }

    private static WordCounter initWordCounter(String stopWordsFileName) throws FileNotFoundException {
        WordMatcher excludeStopWordMatcher = initExcludeStopWordMatcher(stopWordsFileName);
        WordMatcher azWordMatcher = new AzWordMatcherImpl();
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        return new WordCounterImpl(Arrays.asList(azWordMatcher, excludeStopWordMatcher), textSplitter);
    }

    private static WordMatcher initExcludeStopWordMatcher(String s) throws FileNotFoundException {
        InputReader fileInputReader = initFileInputReader("stopwords.txt");
        List<String> stopWords = Arrays.asList(fileInputReader.getInput().split("\n"));
        return new ExcludeStopWordMatcherImpl(stopWords);
    }

}
