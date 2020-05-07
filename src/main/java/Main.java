import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import input.InputReader;
import input.impl.OneLineInputReaderImpl;
import input.impl.WholeInputReaderImpl;
import output.OutputWriter;
import output.impl.StdOutOutputWriter;
import text.obtain.TextObtainer;
import text.obtain.impl.TextObtainerWithIntroTextImpl;
import text.split.TextSplitter;
import text.split.impl.WhiteSpaceTextSplitterImpl;
import word.count.WordCounter;
import word.count.impl.WordCounterImpl;
import word.match.WordMatcher;
import word.match.impl.AzWordMatcherImpl;
import word.match.impl.ExcludeStopWordMatcherImpl;

public class Main {

    private final OutputWriter outputWriter;
    private final TextObtainer textObtainer;
    private final WordCounter wordCounter;

    public Main(OutputWriter outputWriter, TextObtainer textObtainer, WordCounter wordCounter) {
        this.outputWriter = outputWriter;
        this.textObtainer = textObtainer;
        this.wordCounter = wordCounter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        OutputWriter outputWriter = initOutputWriter();
        TextObtainer textObtainer = initTextObtainerForStdIn();

        InputReader fileInputReader = initFileInputReader("stopwords.txt");
        List<String> stopWords = Arrays.asList(fileInputReader.getInput().split("\n"));

        WordMatcher excludeStopWordMatcher = initExcludeStopWordMatcher(stopWords);
        WordMatcher azWordMatcher = initAzWordMatcher();
        TextSplitter textSplitter = initTextSplitter();
        WordCounter wordCounter = initWordCounter(Arrays.asList(azWordMatcher, excludeStopWordMatcher), textSplitter);

        Main main = new Main(
            outputWriter,
            textObtainer,
            wordCounter
        );

        main.run();
    }

    public void run() {
        String text = textObtainer.obtainText();
        long wordCount = wordCounter.count(text);
        outputWriter.write("Number of words: ");
        outputWriter.write(String.valueOf(wordCount));
    }

    private static OutputWriter initOutputWriter() {
        return new StdOutOutputWriter();
    }

    private static InputReader initStdInInputReader() {
        return new OneLineInputReaderImpl(new Scanner(System.in));
    }

    private static InputReader initFileInputReader(String fileName) throws FileNotFoundException {
        return new WholeInputReaderImpl(new Scanner(new FileInputStream(fileName)));
    }

    private static TextObtainer initTextObtainerForStdIn() {
        OutputWriter outputWriter = initOutputWriter();
        InputReader stdInInputReader = initStdInInputReader();
        return initTextObtainerWithIntroText(outputWriter, stdInInputReader, "Enter text: ");
    }

    private static TextObtainer initTextObtainerWithIntroText(OutputWriter outputWriter, InputReader inputReader, String introText) {
        return new TextObtainerWithIntroTextImpl(inputReader, outputWriter, introText);
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
