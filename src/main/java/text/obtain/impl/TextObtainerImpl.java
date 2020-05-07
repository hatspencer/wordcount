package text.obtain.impl;

import input.InputReader;
import text.obtain.TextObtainer;

public class TextObtainerImpl implements TextObtainer {

    private final InputReader inputReader;

    public TextObtainerImpl(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public String obtainText() {
        return inputReader.getInput();
    }
}
