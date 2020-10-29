import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordInputReaderFactoryTest {

    WordInputReaderFactory wordInputReaderFactory;

    @Before
    public void init() {
        wordInputReaderFactory = new WordInputReaderFactory();
    }

    @Test
    public void givenOneArgument_returnWordInputFileReader() {
        String[] args = new String[]{"input.txt"};

        Class<? extends WordInputReader> actual = wordInputReaderFactory.create(args).getClass();
        Class<? extends WordInputReader> expected = WordInputFileReader.class;

        assertEquals(expected, actual);
    }


    @Test
    public void givenOneArgument_returnWordInputConsoleReader() {
        String[] args = new String[]{};

        Class<? extends WordInputReader> actual = wordInputReaderFactory.create(args).getClass();
        Class<? extends WordInputReader> expected = WordInputConsoleReader.class;

        assertEquals(expected, actual);
    }
}
