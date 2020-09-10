package hiring.output;

import hiring.WordCountPrinter;
import hiring.WordCounter.WordCount;

import java.io.PrintStream;

public class PrintStreamWordCountPrinter implements WordCountPrinter {

    private final boolean printIndex;

    public PrintStreamWordCountPrinter(boolean printIndex) {
        this.printIndex = printIndex;
    }

    @Override
    public void printWordCount(WordCount wordCount, PrintStream printStream) {
        printStream.printf("Number of words: %d, unique: %d; average word length: %.2f characters\n",
                wordCount.getTotal(), wordCount.getUnique(), wordCount.getAverageWordLength());
        if (printIndex) {
            printStream.println("Index:");
            for (String word : wordCount.getIndex()) {
                printStream.println(word);
            }
        }
    }
}
