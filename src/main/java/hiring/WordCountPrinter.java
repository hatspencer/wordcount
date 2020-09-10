package hiring;

import hiring.WordCounter.WordCount;

import java.io.PrintStream;

public interface WordCountPrinter {

    void printWordCount(WordCount wordCount, PrintStream printStream);
}
