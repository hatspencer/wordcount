package output.impl;

import output.OutputWriter;

public class StdOutOutputWriter implements OutputWriter {

    @Override
    public void write(String text) {
        System.out.print(text);
    }
}
