package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.OutputStringHandler;

import java.io.OutputStream;
import java.io.PrintStream;

public class OutputStringHandlerImpl implements OutputStringHandler {

    private OutputStream outputStream;

    public OutputStringHandlerImpl( OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void printInput(String output) {
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(output);
    }

}
