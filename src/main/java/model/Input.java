package model;

import java.util.List;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Input {

    private final List<String> input;

    public Input(final List<String> input) {
        this.input = input;
    }

    public String getInputText() {
        return String.join("\n", input);
    }
}
