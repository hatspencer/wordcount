package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.StandartInputHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StandartInputHandlerImplTest {

    @Test
    public void testPrintInput() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        InputStringHandler inputStreamHandler = new StandartInputHandlerImpl(inputStream);
        String requiredInput = inputStreamHandler.readInput();
        Assert.assertEquals("Test", new String(requiredInput));
    }
}
