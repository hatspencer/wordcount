import model.Output;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class ApplicationIntegrationTest {

    private final String INPUT_TEST_CASE = "input-test-case.txt";

    @Test
    public void testPositiveInstanceFromFile() {
        Application application = new Application(new String[]{INPUT_TEST_CASE});

        Output expectedOutput = new Output(4, uniqueWordCount);
        Output actualOutput = application.solveProblem();

        assertEquals("Output did not match with expected.", expectedOutput.getWordCount(),
                actualOutput.getWordCount());
    }

    @Test
    public void testPositiveInstanceFromUserInput() {
        Application application = new Application(new String[]{});

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("Mary had aa little lamb".getBytes());
        System.setIn(in);

        Output expectedOutput = new Output(4, uniqueWordCount);
        Output actualOutput = application.solveProblem();

        System.setIn(sysInBackup);

        assertEquals("Output did not match with expected.", expectedOutput.getWordCount(),
                actualOutput.getWordCount());
    }
}
