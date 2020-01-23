import io.FileReader;
import ui.UserInterface;
import wordcount.WordCounter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String FILE_NAME = "stopwords.txt";

    public static void main(String[] args) throws IOException {
        UserInterface userInterface = new UserInterface(System.out);
        userInterface.initialiseUserInterface();
        Scanner userInput = userInterface.initialiseInputScanner();
        String inputString = userInterface.getUserInput(userInput);
        List<String> stopwords = new FileReader().getStopwords(FILE_NAME);
        int wordCount = new WordCounter(stopwords).countWordsInUserInput(inputString);
        userInterface.printResult(wordCount);
    }
}
