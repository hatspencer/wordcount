import org.junit.Test;

import java.io.IOException;

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
        assertEquals(5, sentence.length());
    }

}