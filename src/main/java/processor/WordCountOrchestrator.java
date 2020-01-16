package processor;

import userinput.UserInputReader;

public class WordCountOrchestrator {

    private String outputText = "Number of words: ";
    private WordCounter wordCounter;
    private UserInputReader userInputReader;

    public WordCountOrchestrator(UserInputReader userInputReader, WordCounter wordCounter){
        this.userInputReader = userInputReader;
        this.wordCounter = wordCounter;
    }

    private void printResultMessage(String result){
        System.out.printf("%s%s", this.outputText, result);
        System.out.println();
    }

    public void process(){
        printResultMessage(String.valueOf(wordCounter.countWords(userInputReader.readUserInput())));
    }
}
