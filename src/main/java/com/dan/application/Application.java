package com.dan.application;

import com.dan.input.Input;
import com.dan.input.InputParamReader;
import com.dan.input.InputReader;
import com.dan.input.UserInputReader;
import com.dan.output.FactPrinter;
import com.dan.output.IndexPrinter;

public class Application {

    public static void main(String[] args) {
        InputReader inputParamsReader = new InputParamReader(args);
        Input input = inputParamsReader.readInput();

        if (input.hasText()) {
            process(input);
        } else {
            processUserInputs(input);
        }
    }

    private static void processUserInputs(Input previousInput) {
        InputReader userInputReader = new UserInputReader(previousInput);

        while (true) {
            Input input = userInputReader.readInput();

            if (!input.hasText()) break;

            process(input);
        }
    }

    private static void process(Input input) {
        new FactPrinter(input).print();
        new IndexPrinter(input).print();
    }

}
