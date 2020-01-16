package processor;

import wordcounter.SimpleWordCounter;

import java.util.Scanner;

public class ConsoleInputOrchestrator extends WordCountOrchestrator{

    public ConsoleInputOrchestrator(StopWordReader stopWordReader){
        this.stopWordReader = stopWordReader;
    }

    @Override
    public void process(){
        printWelcomeMessage();
        WordCounter wordCounter = new SimpleWordCounter(readUserInput(), stopWordReader.getStopWords());
        printResultMessage(String.valueOf(wordCounter.countWords()));
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
