import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class FileInputProcessorServiceTest {

    private FileInputProcessorService fileInputProcessorService;

    @Test
    public void shouldReturnTextFromFile() {
        fileInputProcessorService = new FileInputProcessorService(FileInputProcessorService.CLASSPATH_PREFIX + "inputTest.txt");
        String result = fileInputProcessorService.prepareTextInput();

        assertEquals("Mary had a little lamb", result);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowTheException_whenFileNotFound() {
        fileInputProcessorService = new FileInputProcessorService(FileInputProcessorService.CLASSPATH_PREFIX + "blabla.txt");
        fileInputProcessorService.prepareTextInput();
    }
}
