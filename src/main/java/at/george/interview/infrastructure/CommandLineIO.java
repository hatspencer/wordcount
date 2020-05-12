package at.george.interview.infrastructure;

import at.george.interview.domain.IO;

import java.io.*;

public class CommandLineIO implements IO {

    public String readTextInputLine() {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        return mapErrorsToResult(reader);
    }

    String mapErrorsToResult(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void printlnTextOutput(String output) {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(output);
        printWriter.flush();
    }
}
