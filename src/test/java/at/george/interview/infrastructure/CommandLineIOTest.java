package at.george.interview.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class CommandLineIOTest {

    private CommandLineIO sut = new CommandLineIO();

    private InputStream inputStreamBackup;

    private PrintStream printStreamBackup;

    @Before
    public void backupStreams() {
        inputStreamBackup = System.in;
        printStreamBackup = System.out;
    }

    @After
    public void restoreStreams() {
        System.setIn(inputStreamBackup);
        System.setOut(printStreamBackup);
    }

    @Test
    public void readsFromCommandLine() {
        // SETUP
        InputStream stream = new ByteArrayInputStream("hallo welt".getBytes());
        System.setIn(stream);

        // RUN
        String input = sut.readTextInputLine();

        // ASSERT
        assertEquals("hallo welt", input);
    }

    @Test
    public void writeToCommandLine() {
        // SETUP
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // RUN
        sut.printlnTextOutput("sample output for test");

        // ASSERT
        String outputAsString = outputStream.toString();
        assertEquals("sample output for test\n", outputAsString);
    }

    @Test
    public void ioExceptionDefaultsToEmptyResult() {

        BufferedReader faultyReader= createFaultyReader();
        String result = sut.mapErrorsToResult(faultyReader);

        assertEquals("", result);
    }

    private BufferedReader createFaultyReader() {
        return new BufferedReader(new StringReader("IRRELEVANT")) {

            @Override
            public String readLine() throws IOException {
                throw new IOException("Dummy Error for the sake for the test");
            }
        };
    }


}