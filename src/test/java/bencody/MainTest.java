package bencody;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void should_read_input_from_stdin_with_no_main_args() {
        System.setIn(new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes()));
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{});

        String sout = bo.toString();

        assertThat(sout, equalTo(
                "Enter text:" + LINE_SEPARATOR +
                        "Number of words: 7, unique: 6; average word length: 6.43 characters" + LINE_SEPARATOR));
    }

    @Test
    public void should_read_input_from_text_file_given_1_main_arg() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{"src/test/resources/mytext.txt"});

        String sout = bo.toString();
        assertThat(sout, equalTo("Number of words: 4, unique: 4; average word length: 4.25 characters" + LINE_SEPARATOR));
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_if_text_file_main_arg_not_found() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{"doesnotexist.txt"});
    }

    @Test
    public void should_create_index_if_specified() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{"src/test/resources/mytext.txt", "-wordIndex"});

        String sout = bo.toString();
        assertThat(sout, equalTo(
                "Number of words: 4, unique: 4; average word length: 4.25 characters" + LINE_SEPARATOR +
                        "Index:" + LINE_SEPARATOR +
                        "had" + LINE_SEPARATOR +
                        "lamb" + LINE_SEPARATOR +
                        "little" + LINE_SEPARATOR +
                        "Mary" + LINE_SEPARATOR
        ));
    }
}
