package text.obtain.impl;

import input.InputReader;
import output.OutputWriter;
import text.obtain.TextObtainer;

public class TextObtainerImpl implements TextObtainer {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public TextObtainerImpl(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public String obtainText(String introText) {
        outputWriter.write(introText);
        return inputReader.getInputLine();
    }
}
