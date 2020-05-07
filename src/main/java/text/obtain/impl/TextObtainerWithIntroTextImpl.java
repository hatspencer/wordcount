package text.obtain.impl;

import input.InputReader;
import output.OutputWriter;

public class TextObtainerWithIntroTextImpl extends TextObtainerImpl {

    private final OutputWriter outputWriter;
    private final String introText;

    public TextObtainerWithIntroTextImpl(InputReader inputReader, OutputWriter outputWriter, String introText) {
        super(inputReader);
        this.outputWriter = outputWriter;
        this.introText = introText;
    }

    @Override
    public String obtainText() {
        outputWriter.write(introText);
        return super.obtainText();
    }
}
