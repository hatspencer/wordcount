package text.obtain.impl;

import input.UserInputReader;
import output.OutputWriter;
import text.obtain.TextObtainer;

public class TextObtainerImpl implements TextObtainer {

    private final UserInputReader userInputReader;
    private final OutputWriter outputWriter;

    public TextObtainerImpl(UserInputReader userInputReader, OutputWriter outputWriter) {
        this.userInputReader = userInputReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public String obtainText() {
        outputWriter.write("Enter text: ");
        return userInputReader.getInputLine();
    }
}
