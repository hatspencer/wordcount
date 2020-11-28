package com.dan.application;

import com.dan.input.Input;
import com.dan.input.InputParamReader;
import com.dan.input.InputParamReaderImpl;
import com.dan.output.FactPrinter;
import com.dan.output.IndexPrinter;

public class Application {

    public static void main(String[] args) {
        Input input = readInput(args);

        new FactPrinter(input).print();
        new IndexPrinter(input).print();
    }

    private static Input readInput(String[] args) {
        InputParamReader inputReader = new InputParamReaderImpl();
        return inputReader.readInput(args);
    }

}
