package hiring.output;

import hiring.WordCountPrinter;
import hiring.WordCounter.WordCount;
import hiring.WordsRepository;

import java.io.PrintStream;

public class PrintStreamWordCountPrinter implements WordCountPrinter {

    private final WordsRepository dictionaryWordsRepository;
    private final boolean printIndex;

    public PrintStreamWordCountPrinter(WordsRepository dictionaryWordsRepository, boolean printIndex) {
        this.dictionaryWordsRepository = dictionaryWordsRepository;
        this.printIndex = printIndex;
    }

    @Override
    public void printWordCount(WordCount wordCount, PrintStream printStream) {
        printStream.printf("Number of words: %d, unique: %d; average word length: %.2f characters\n",
                wordCount.getTotal(), wordCount.getUnique(), wordCount.getAverageWordLength());
        if (printIndex) {
            printIndex(wordCount, printStream);
        }
    }

    private void printIndex(WordCount wordCount, PrintStream printStream) {
        if (dictionaryWordsRepository != null) {
            long unknownWords = wordCount.getIndex().stream().filter(this::isUnknownWord).count();
            printStream.printf("Index (unknown: %d):\n", unknownWords);
            for (String word : wordCount.getIndex()) {
                printStream.println(word + (isUnknownWord(word) ? "*" : ""));
            }
        } else {
            printStream.println("Index:");
            for (String word : wordCount.getIndex()) {
                printStream.println(word);
            }
        }
    }

    private boolean isUnknownWord(String word) {
        return !dictionaryWordsRepository.containsWord(word);
    }
}
