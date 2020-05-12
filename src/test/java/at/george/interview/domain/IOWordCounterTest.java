package at.george.interview.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOWordCounterTest {

    private static class MockedIO implements IO {

        private String input;
        private String output;
        private String query;

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }


        public String getQuery() {
            return query;
        }

        @Override
        public String readTextInputLine() {
            return input;
        }

        @Override
        public void printlnResultOutput(String output) {
            this.output = output;
        }

        @Override
        public void printInputQuery(String query) {
            this.query = query;
        }
    }

    private static class MockedCounter implements WordCounter {

        @Override
        public long countWords(String inputText) {
            return inputText.split("\\s+").length;
        }
    }

    private MockedIO mockedIO;

    private IOWordCounter sut;

    @Before
    public void initMock() {

        mockedIO = new MockedIO();
        MockedCounter mockedCounter = new MockedCounter();

        sut = new IOWordCounter(mockedIO, mockedCounter);
    }

    @Test
    public void checkPrintingOfQueryString() {
        // SETUP
        mockedIO.setInput("whatever");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String query = mockedIO.query;
        assertEquals("Enter text: ", query);
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
        mockedIO.setInput("hello     there");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String output = mockedIO.getOutput();
        assertEquals("Number of words: 2", output );

    }

    @Test
    public void countAlsoNumbers() {

        // SETUP
        mockedIO.setInput("hello there 1 2 3");

        // PERFORM
        sut.printCountedWords();

        // CHECK
        String output = mockedIO.getOutput();
        assertEquals("Number of words: 5", output );

    }

}