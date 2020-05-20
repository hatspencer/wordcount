package cz.rleifer.test.wordcounter.core;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class IOHandlerTest {

    private IOHandler ioHandler;

    @Test
    public void testPrintOutput() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ioHandler = new IOHandlerImpl(inputStream, outputStream);
        ioHandler.printInput("Test");
        Assert.assertEquals("Test" + System.lineSeparator(), new String(outputStream.toByteArray()));
    }

    @Test
    public void testPrintInput() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ioHandler = new IOHandlerImpl(inputStream, outputStream);
        String requiredInput = ioHandler.readInput();
        Assert.assertEquals("Test", new String(requiredInput));
    }
}
