import java.util.List;

import com.erste.main.io.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTest {

    private static final String EXISTING_FILENAME = "filereadertest.txt";
    private static final String NONEXISTING_FILENAME = "fwafwafwafwa.txt";

    @Test
    public void readFileNonExistingFileExpectEmptyList() {
        List<String> lines = FileReader.readFileAsLines(NONEXISTING_FILENAME);
        Assertions.assertTrue(lines.isEmpty());
    }

    @Test
    public void readFileExpectListWithFourItems() {
        Assertions.assertEquals(4, FileReader.readFileAsLines(EXISTING_FILENAME).size());
    }
}
