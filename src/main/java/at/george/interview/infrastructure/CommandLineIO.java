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
            // would have used logger here
            return "";
        }
    }

    public void printlnResultOutput(String output) {
        System.out.println(output);
    }

    @Override
    public void printInputQuery(String query) {
        System.out.print(query);
    }
}
