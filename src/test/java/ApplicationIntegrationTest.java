import model.Output;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marton Bartal on 15.10.2020.
 * Integration test for testing inputs through different input methods.
 */
public class ApplicationIntegrationTest {

    private final String INPUT_TEST_CASE = "input-test-case.txt";

    @Test
    public void testPositiveInstanceFromFile() {
        Application application = new Application(new String[]{INPUT_TEST_CASE});

        Output expectedOutput = new Output(4, 4, 4.25);
        Output actualOutput = application.solveProblem();

        assertEquals("Output word count did not match with expected.",
                expectedOutput.getWordCount(), actualOutput.getWordCount());
        assertEquals("Output unique word count did not match with expected.",
                expectedOutput.getUniqueWordCount(), actualOutput.getUniqueWordCount());
        assertEquals("Output average word length did not match with expected.",
                expectedOutput.getAvgWordLength(), actualOutput.getAvgWordLength(), 0.0);
    }

    @Test
    public void testPositiveInstanceFromUserInput() {
        Application application = new Application(new String[]{});

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("Mary had aa little lamb".getBytes());
        System.setIn(in);

        Output expectedOutput = new Output(4, 4, 4.25);
        Output actualOutput = application.solveProblem();

        System.setIn(sysInBackup);

        assertEquals("Output word count did not match with expected.",
                expectedOutput.getWordCount(), actualOutput.getWordCount());
        assertEquals("Output unique word count did not match with expected.",
                expectedOutput.getUniqueWordCount(), actualOutput.getUniqueWordCount());
        assertEquals("Output average word length did not match with expected.",
                expectedOutput.getAvgWordLength(), actualOutput.getAvgWordLength(), 0.0);
    }
}
