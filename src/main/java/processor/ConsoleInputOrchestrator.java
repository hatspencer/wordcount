package processor;

import java.util.Scanner;

public class ConsoleInputOrchestrator extends WordCountOrchestrator{

    private WordCounter wordCounter;

    public ConsoleInputOrchestrator(StopWordReader stopWordReader, WordCounter wordCounter){
        this.stopWordReader = stopWordReader;
        this.wordCounter = wordCounter;
    }

    @Override
    public void process(){
        printWelcomeMessage();
        printResultMessage(String.valueOf(wordCounter.countWords(readUserInput())));
    }

    private String readUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printWelcomeMessage(){
        String welcomeText = "Enter text: ";
        System.out.print(welcomeText);
    }
}
