package at.george.wordcount;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    public static final String PATH_TO_FILE_READER_TXT = "test_forFileReader.txt";

    @Test
    void canReadFileAsList() {
        FileReader fileReader = new FileReader();
        List<String> actual = fileReader.asList(PATH_TO_FILE_READER_TXT);

        List<String> expected = Stream.of("The", "test", "for", "file", "reader")
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}
