import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SentenceReaderTest {

    @Test
    public void should_read_data_file() throws IOException {
        // given
        final SentenceReader sentenceReader = new SentenceReader();
        final URL resourceURL = WordCounter.class.getResource("mytext.txt");
        final String[] args = {resourceURL.getFile()};

        // when
        final String sentence = sentenceReader.read(args);

        // then
        assertTrue(sentence.length() > 0);
    }

}