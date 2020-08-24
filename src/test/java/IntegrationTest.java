import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IntegrationTest {

    private static final String EOL = System.getProperty("line.separator");

    @Test
    public void testFileInput() throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        WordCountMain.outputStream = new PrintStream(out);
        WordCountMain.main(new String[]{"mytext.txt"});
        assertEquals("Number of words 4, unique 4, average word length:  4,25 characters" + EOL, out.toString());
    }

    @Test
    public void testFileInputWithIndex() throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        WordCountMain.outputStream = new PrintStream(out);
        WordCountMain.main(new String[]{"mytext.txt", "-index"});
        // TODO The order of the index entries may change - this needs to be made more stable.
        assertEquals("Number of words 4, unique 4, average word length:  4,25 characters" + EOL +
                "Index:" + EOL + "lamb" + EOL + "had" + EOL + "little" + EOL + "Mary" + EOL,
                out.toString());
    }
}
