import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SentenceReaderTest {

    @Test
    public void should_read_data_file() throws IOException {
        // given
        final SentenceReader sentenceReader = new SentenceReader();
        final String[] test = {"mytext.txt"};

        // when
        List<String> words = sentenceReader.read(test);

        // then

    }

}