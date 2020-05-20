package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.FileInputHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Optional;

public class FileInputHandlerImplTest {
    private static String LINE_1 = "The application can be started with a filename";
    private static String LINE_2 = "to read the text from instead of entering it manually.";

    @Test
    public void testPrintInput() throws IOException {
        try (Reader fileReader = new StringReader(LINE_1 + System.lineSeparator() + LINE_2) ) {
            FileInputHandlerImpl fileInputHandler = new FileInputHandlerImpl(fileReader);
            fileInputHandler.next();
            Optional<String> line1 = fileInputHandler.readLine();
            fileInputHandler.next();
            Optional<String> line2 = fileInputHandler.readLine();
            Assert.assertEquals(LINE_1, line1.get());
            Assert.assertEquals(LINE_2, line2.get());
        }

    }

    @Test
    public void testNext() throws IOException {
         try (Reader fileReader = new StringReader(LINE_1 + System.lineSeparator() + LINE_2) ) {
            FileInputHandlerImpl fileInputHandler = new FileInputHandlerImpl(fileReader);
            Optional<String> lineIsNotReturned = fileInputHandler.readLine();
            fileInputHandler.next();
            Optional<String> line1 = fileInputHandler.readLine();
            Assert.assertFalse(lineIsNotReturned.isPresent());
            Assert.assertEquals(LINE_1, line1.get());
        }
    }
}
