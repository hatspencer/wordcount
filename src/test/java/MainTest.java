import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    @Test
    public void should_read_input_from_stdin_with_no_main_args() {
        System.setIn(new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes()));
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{});

        String sout = bo.toString();
        assertThat(sout, equalTo("Enter text:\r\nNumber of words: 9, unique: 7\r\n"));
    }

    @Test
    public void should_read_input_from_text_file_given_1_main_arg() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{"src/test/resources/mytext.txt"});

        String sout = bo.toString();
        assertThat(sout, equalTo("Number of words: 4, unique: 4\r\n"));
    }
}
