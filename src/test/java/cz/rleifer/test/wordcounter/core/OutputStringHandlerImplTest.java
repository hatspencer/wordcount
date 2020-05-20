package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.OutputStringHandlerImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class OutputStringHandlerImplTest {

    private OutputStringHandler outputStringHandler;

    @Test
    public void testPrintOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStringHandler = new OutputStringHandlerImpl(outputStream);
        outputStringHandler.printInput("Test");
        Assert.assertEquals("Test" + System.lineSeparator(), new String(outputStream.toByteArray()));
    }

}
