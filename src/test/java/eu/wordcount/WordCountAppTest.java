package eu.wordcount;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCountAppTest {

    private WordCountApp underTest;

    private WordReader readerStub;
    private WordCounter counterStub;
    private MyWriter writerStub;

    private List<String> outputLines;

    @Before
    public void setUp() {
        outputLines = new ArrayList<>();

        readerStub = () -> "Mary had a little lamb";
        counterStub = input -> 9;
        writerStub = output -> outputLines.add(output);

        underTest = new WordCountApp(
                readerStub,
                counterStub,
                writerStub
        );
    }

    @Test
    public void whenCallingCountWords_thenTwoLinesShouldBeWrittenToTheOutput() {
        int expected = 2;
        underTest.countWords();
        int actual = outputLines.size();
        assertEquals("Output should contain two lines", expected, actual);
    }

    @Test
    public void whenCallingCountWords_thenCorrectPromptShouldBeWritten() {
        String expected = "Enter text: ";
        underTest.countWords();
        final String actual = outputLines.get(0);
        assertEquals("Output should match the expectation", expected, actual);
    }

    @Test
    public void whenCallingCountWords_thenCorrectCountNumberShouldBeWritten() {
        String expected = "Number of words: 9\n";
        underTest.countWords();
        final String actual = outputLines.get(1);
        assertEquals("Output should match the expectation", expected, actual);
    }
}
