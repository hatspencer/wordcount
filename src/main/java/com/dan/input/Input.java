package com.dan.input;

public class Input {

    private String text;
    private String param;

    private Input() { }

    public String getText() {
        return text;
    }

    public String getParam() {
        return param;
    }

    public boolean hasText() {
        return (text != null);
    }

    public boolean hasIndex() {
        return "index".equalsIgnoreCase(param);
    }

    public static InputBuilder builder() {
        return builder(new Input());
    }

    public static InputBuilder builder(Input input) {
        return new InputBuilder(input);
    }

    public static class InputBuilder {

        private Input input;

        private InputBuilder(Input input) { this.input = input; };

        public InputBuilder withText(String text) {
            input.text = text;
            return this;
        }

        public InputBuilder withParam(String param) {
            input.param = param;
            return this;
        }

        public boolean isComplete() {
            return this.input.text != null && this.input.param != null;
        }

        public Input build() {
            return input;
        }

    }
}
