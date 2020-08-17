import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class SentenceReaderTest {

    @Test
    public void should_read_data_file() throws IOException {
        // given
        final SentenceReader sentenceReader = new SentenceReader();
        final String[] args = {"src/main/resources/mytext.txt"};

        // when
        final String sentence = sentenceReader.read(args);

        // then
        assertEquals(22, sentence.length());
    }

    @Test
    public void should_not_read_file_if_not_exists() throws IOException {
        // given
        final SentenceReader sentenceReader = new SentenceReader();
        final String[] args = new String[0];

        // when
        final InputStream in = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(in);
        final String sentence = sentenceReader.read(args);
        System.setIn(System.in);

        // then
        assertEquals(22, sentence.length());
    }

}