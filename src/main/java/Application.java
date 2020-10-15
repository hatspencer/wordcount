import model.Input;
import model.Output;
import solver.WordCounter;
import util.LineReader;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Application {

    private static final String STOPWORDS_FILENAME = "stopwords.txt";
    private String inputFileName = null;

    public Application(String[] args) {
        if (args != null && args.length == 1) {
            this.inputFileName = args[0];
        }
    }

    public Output solveProblem() {
        return calculateOutput(readInput());
    }

    private Input readInput() {
        Input input;
        if (this.inputFileName != null) {
            LineReader lineReader = new LineReader(this.inputFileName);
            input = new Input(lineReader.readLinesFromFile());
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input your text for word counting.");
            input = new Input(Collections.singletonList(scanner.nextLine()));
        }
        return input;
    }

    private Output calculateOutput(Input input) {
        LineReader lineReader = new LineReader(STOPWORDS_FILENAME);
        WordCounter wordCounter = new WordCounter(lineReader.readLinesFromFile());

        return wordCounter.countWords(input.getInputText());
    }
}
