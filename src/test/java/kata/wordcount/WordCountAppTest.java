package kata.wordcount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

    @Test
    public void count() {
        ConsoleInputReader inputMock = new InputReaderMock("Mary had a little lamb");
        OutputWriterMock outputMock = new OutputWriterMock();
        StopwordsLoader stopwordsLoader = new StopwordsLoaderMock();
        WordCountApp app = new WordCountApp(inputMock, outputMock, stopwordsLoader);

        app.count();

        assertThat(outputMock.getNumberOfWords(), is(4L));
    }
}
