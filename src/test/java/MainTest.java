import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

    @Test
    public void should_output_number_of_words() {
        System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Main.main(new String[]{});

        String sout = bo.toString();
        assertThat(sout, equalTo("todo"));
    }
}
