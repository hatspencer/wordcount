package orchestrator;

import userinput.UserInputReader;

public class WordCountOrchestrator {

    private WordCounter wordCounter;
    private UserInputReader userInputReader;

    public WordCountOrchestrator(UserInputReader userInputReader, WordCounter wordCounter){
        this.userInputReader = userInputReader;
        this.wordCounter = wordCounter;
    }

    private void printResultMessage(String result){
        String outputText = "Number of words: ";
        System.out.printf("%s%s", outputText, result);
        System.out.println();
    }

    public void process(){
        printResultMessage(String.valueOf(wordCounter.countAllWords(userInputReader.readUserInput())));
    }
}
