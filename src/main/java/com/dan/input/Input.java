package com.dan.input;

import com.dan.util.FileReader;

import java.io.IOException;
import java.util.function.Consumer;

public class Input {

    private String textContents;
    private Boolean buildIndex;
    private String dictionaryContents;

    private Input() { }

    public String getTextContents() {
        return textContents;
    }

    public boolean hasText() {
        return (textContents != null) && !textContents.isEmpty();
    }

    public boolean hasIndex() {
        return buildIndex;
    }

    public String getDictionaryContents() {
        return dictionaryContents;
    }

    public boolean hasDictionary() {
        return (dictionaryContents != null);
    }

    public static InputBuilder builder() {
        return builder(new Input());
    }

    public static InputBuilder builder(Input input) {
        return new InputBuilder(input);
    }

    public void process(Consumer<Input> consumer) {
        consumer.accept(this);
    }

    public static class InputBuilder {

        private Input input;

        private InputBuilder(Input input) { this.input = input; };

        public InputBuilder withTextContent(String text) {
            input.textContents = text;
            return this;
        }

        public InputBuilder withTextFile(String filePath) {
            input.textContents = readFile(filePath);
            return this;
        }

        public InputBuilder withIndex(boolean hasIndex) {
            input.buildIndex = hasIndex;
            return this;
        }

        public InputBuilder withIndex() {
            return withIndex(true);
        }

        public boolean hasIndex() {
            return (input.buildIndex != null) && input.buildIndex;
        }

        public InputBuilder withDictionaryFile(String filePath) {
            input.dictionaryContents = readFile(filePath);
            return this;
        }

        public boolean isComplete() {
            return this.input.textContents != null &&
                    this.input.buildIndex != null &&
                    this.input.dictionaryContents != null;
        }

        public Input build() {
            if (input.buildIndex == null) input.buildIndex = Boolean.FALSE;
            return input;
        }

        private String readFile(String filePath) {
            try {
                return FileReader.readFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
