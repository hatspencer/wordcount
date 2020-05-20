package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.InputStringHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputStringHandlerImplTest {

    @Test
    public void testPrintInput() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        InputStringHandler inputStreamHandler = new InputStringHandlerImpl(inputStream);
        String requiredInput = inputStreamHandler.readInput();
        Assert.assertEquals("Test", new String(requiredInput));
    }
}
