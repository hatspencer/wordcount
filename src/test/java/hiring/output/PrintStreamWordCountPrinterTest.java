package hiring.output;

import hiring.WordCounter.WordCount;
import hiring.WordsRepository;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PrintStreamWordCountPrinterTest {

    @Test
    public void printWordCount_noIndex() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WordCount wordCount = mockWordCount();

        PrintStreamWordCountPrinter printer = new PrintStreamWordCountPrinter(null, false);
        printer.printWordCount(wordCount, new PrintStream(outputStream));

        String expected = "Number of words: 1, unique: 1; average word length: 1.00 characters" + System.lineSeparator();
        String output = new String(outputStream.toByteArray());
        Assert.assertEquals(expected, output);
    }

    @Test
    public void printWordCount_printIndexNoDictionary() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WordCount wordCount = mockWordCount("aaa");

        PrintStreamWordCountPrinter printer = new PrintStreamWordCountPrinter(null, true);
        printer.printWordCount(wordCount, new PrintStream(outputStream));

        String expected = "Number of words: 1, unique: 1; average word length: 1.00 characters" + System.lineSeparator() +
                "Index:" + System.lineSeparator() +
                "aaa" + System.lineSeparator();
        String output = new String(outputStream.toByteArray());
        Assert.assertEquals(expected, output);
    }

    @Test
    public void printWordCount_printIndexWithDictionary() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WordCount wordCount = mockWordCount("aaa", "bbb", "ccc");
        WordsRepository dictionaryWordsRepository = mockDictionaryWordsRepository("aaa");

        PrintStreamWordCountPrinter printer = new PrintStreamWordCountPrinter(dictionaryWordsRepository, true);
        printer.printWordCount(wordCount, new PrintStream(outputStream));

        String expected = "Number of words: 1, unique: 1; average word length: 1.00 characters" + System.lineSeparator() +
                "Index (unknown: 2):" + System.lineSeparator() +
                "aaa" + System.lineSeparator() +
                "bbb*" + System.lineSeparator() +
                "ccc*" + System.lineSeparator();
        String output = new String(outputStream.toByteArray());
        Assert.assertEquals(expected, output);
    }

    private WordCount mockWordCount(String... words) {
        Set<String> index = new TreeSet<>(Arrays.asList(words));
        return new WordCount(1, 1, 1, index);
    }

    private WordsRepository mockDictionaryWordsRepository(String... words) {
        return word -> Arrays.asList(words).contains(word);
    }
}
