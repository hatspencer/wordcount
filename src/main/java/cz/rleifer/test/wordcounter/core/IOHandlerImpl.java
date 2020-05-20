package cz.rleifer.test.wordcounter.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOHandlerImpl implements IOHandler {
    private InputStream inputStream;
    private OutputStream outputStream;

    public IOHandlerImpl(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public String readInput() {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }

    public void printInput(String output) {
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(output);
    }
}
