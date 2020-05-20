package cz.rleifer.test.wordcounter.core;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class IOStringHandlerImplTest {

    private IOStringHandler ioStringHandler;

    @Test
    public void testPrintOutput() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ioStringHandler = new IOStringHandlerImpl(inputStream, outputStream);
        ioStringHandler.printInput("Test");
        Assert.assertEquals("Test" + System.lineSeparator(), new String(outputStream.toByteArray()));
    }

    @Test
    public void testPrintInput() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ioStringHandler = new IOStringHandlerImpl(inputStream, outputStream);
        String requiredInput = ioStringHandler.readInput();
        Assert.assertEquals("Test", new String(requiredInput));
    }
}
