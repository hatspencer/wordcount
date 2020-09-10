package hiring.output;

import hiring.WordCounter.WordCount;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

public class PrintStreamWordCountPrinterTest {

    @Test
    public void printWordCount_noIndex() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WordCount wordCount = createTestWordCount();

        PrintStreamWordCountPrinter printer = new PrintStreamWordCountPrinter(false);
        printer.printWordCount(wordCount, new PrintStream(outputStream));

        String expected = "Number of words: 1, unique: 1; average word length: 1.00 characters\n";
        String output = new String(outputStream.toByteArray());
        Assert.assertEquals(expected, output);
    }

    @Test
    public void printWordCount_printIndex() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WordCount wordCount = createTestWordCount();

        PrintStreamWordCountPrinter printer = new PrintStreamWordCountPrinter(true);
        printer.printWordCount(wordCount, new PrintStream(outputStream));

        String expected = "Number of words: 1, unique: 1; average word length: 1.00 characters\n" +
                "Index:\n" +
                "aaa\n";
        String output = new String(outputStream.toByteArray());
        Assert.assertEquals(expected, output);
    }

    private WordCount createTestWordCount() {
        return new WordCount(1, 1, 1, Collections.singleton("aaa"));
    }
}
