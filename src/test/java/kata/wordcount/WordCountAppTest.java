package kata.wordcount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCountAppTest {

    @Test
    public void count_withMockedDependencies() {
        ConsoleInputReader inputMock = new InputReaderMock("Mary had a little lamb");
        OutputWriterMock outputMock = new OutputWriterMock();
        StopwordsLoader stopwordsLoader = new StopwordsLoaderMock();
        WordCountApp app = new WordCountApp(inputMock, outputMock, stopwordsLoader);

        app.count();

        assertThat(outputMock.getNumberOfWords(), is(4L));
    }

    @Test
    public void count_readTextFromFile() {
        InputReader fileInputReader = new FileInputReader("src/test/resources/mytext.txt");
        OutputWriterMock outputMock = new OutputWriterMock();
        StopwordsLoader stopwordsLoader = new StopwordsLoaderMock();
        WordCountApp app = new WordCountApp(fileInputReader, outputMock, stopwordsLoader);

        app.count();

        assertThat(outputMock.getNumberOfWords(), is(4L));
    }

    @Test
    public void createInputReader_withPathProvided() {
        InputReader inputReader = WordCountApp.createInputReader(new String[]{"src/test/resources/mytext.txt"});
        assertThat(inputReader, instanceOf(FileInputReader.class));
    }

    @Test
    public void createInputReader_withNoPathProvided() {
        InputReader inputReader = WordCountApp.createInputReader(new String[]{});
        assertThat(inputReader, instanceOf(ConsoleInputReader.class));
    }
}
