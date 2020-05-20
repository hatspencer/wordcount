package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.StandardInputHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

public class StandardInputHandlerImplTest {

    @Test
    public void testPrintInput() throws IOException {
        InputStringHandler inputStreamHandler = getInputStringHandler();
        inputStreamHandler.next();
        Optional<String> requiredInput = inputStreamHandler.readLine();
        Assert.assertEquals("Test", new String(requiredInput.get()));
    }

    @Test
    public void testHasNext() throws IOException {
        InputStringHandler inputStreamHandler = getInputStringHandler();
        Assert.assertTrue(inputStreamHandler.next());
        inputStreamHandler.readLine();
        Assert.assertFalse(inputStreamHandler.next());
     }

    private InputStringHandler getInputStringHandler() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test".getBytes());
        return new StandardInputHandlerImpl(inputStream);
    }


}
