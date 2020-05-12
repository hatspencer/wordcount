package at.george.interview.domain;

import at.george.interview.domain.counters.AlphabeticWordCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOWordCounterTest {

    private static class MockedIO implements IO {

        private String input;
        private String output;

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        @Override
        public String readTextInput() {
            return input;
        }

        @Override
        public void writeTextOutput(String output) {
            this.output = output;
        }
    }

    private MockedIO mockedIO;

    private IOWordCounter sut;

    @Before
    public void initMock() {
        AlphabeticWordCounter wordCounter = new AlphabeticWordCounter();

        mockedIO = new MockedIO();
        sut = new IOWordCounter(mockedIO, wordCounter);
    }


    @Test
    public void printOneForSingleWord() {

        // SETUP
        mockedIO.setInput("hello");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String output = mockedIO.getOutput();
        assertEquals("Number of words: 1", output );

    }

    @Test
    public void printZeroForWhitespacesOnly() {

        // SETUP
        mockedIO.setInput("        ");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String output = mockedIO.getOutput();
        assertEquals("Number of words: 0", output );

    }

    @Test
    public void checkForIgnoredElementsInOutput() {

        // SETUP
        mockedIO.setInput("hello  there , how are you ? ");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String output = mockedIO.getOutput();
        assertEquals("Number of words: 5", output );

    }

}