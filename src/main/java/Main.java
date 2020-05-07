import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
import word.filter.WordFilter;
import word.filter.impl.AzWordFilterImpl;
import word.filter.impl.ExcludedWordFilterImpl;
import word.filter.impl.UniqueWordFilterImpl;

public class Main {

    private static final String EXCLUDED_WORDS_FILENAME = "stopwords.txt";
    private static final String WORDS_COUNT_INTRO_TEXT = "Number of words: ";
    private static final String UNIQUE_COUNT_INTRO_TEXT = "unique: : ";
    private static final String INPUT_TEXT_READING_INTRO_TEXT = "Enter text: ";

    private final OutputWriter resultOutputWriter;
    private final TextObtainer inputTextObtainer;
    private final Collection<WordCounter> wordCounters;

    public Main(OutputWriter resultOutputWriter, TextObtainer inputTextObtainer, Collection<WordCounter> wordCounters) {
        this.resultOutputWriter = resultOutputWriter;
        this.inputTextObtainer = inputTextObtainer;
        this.wordCounters = wordCounters;
    }

    public static void main(String[] args) throws FileNotFoundException {
        TextObtainer inputTextObtainer = initTextObtainerBasedOnArguments(args);
        OutputWriter resultOutputWriter = new StdOutOutputWriter();
        WordCounter wordCounter = initWordCounter(EXCLUDED_WORDS_FILENAME);
        WordCounter uniqueWordCounter = initUniqueWordCounter(EXCLUDED_WORDS_FILENAME);

        Main main = new Main(resultOutputWriter, inputTextObtainer, Arrays.asList(wordCounter, uniqueWordCounter));
        main.run();
    }

    public void run() {
        String text = inputTextObtainer.obtainText();
        String output = wordCounters.stream()
                .map(counter -> counter.getCountDescription() + counter.count(text))
                .collect(Collectors.joining(", "));

        resultOutputWriter.write(output);
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
        return new TextObtainerWithIntroTextImpl(stdInInputReader, stdOutOutputWriter, INPUT_TEXT_READING_INTRO_TEXT);
    }

    private static InputReader initFileInputReader(String fileName) throws FileNotFoundException {
        return new WholeInputReaderImpl(new Scanner(new FileInputStream(fileName)));
    }

    private static InputReader initStdInInputReader() {
        return new OneLineInputReaderImpl(new Scanner(System.in));
    }

    private static WordCounter initWordCounter(String excludedWordsFileName) throws FileNotFoundException {
        WordFilter excludedWordFilter = initExcludeStopWordFilter(excludedWordsFileName);
        WordFilter azWordFilter = new AzWordFilterImpl();
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        return new WordCounterImpl(Arrays.asList(azWordFilter, excludedWordFilter), textSplitter, WORDS_COUNT_INTRO_TEXT);
    }

    private static WordFilter initExcludeStopWordFilter(String excludedWordsFileName) throws FileNotFoundException {
        InputReader fileInputReader = initFileInputReader(excludedWordsFileName);
        List<String> excludedWords = fileInputReader.getInputByLines();
        return new ExcludedWordFilterImpl(excludedWords);
    }

    private static WordCounter initUniqueWordCounter(String excludedWordsFileName) throws FileNotFoundException {
        WordFilter excludedWordFilter = initExcludeStopWordFilter(excludedWordsFileName);
        WordFilter azWordFilter = new AzWordFilterImpl();
        WordFilter uniqueFilter = new UniqueWordFilterImpl();
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        return new WordCounterImpl(Arrays.asList(azWordFilter, excludedWordFilter, uniqueFilter), textSplitter, UNIQUE_COUNT_INTRO_TEXT);
    }

}
