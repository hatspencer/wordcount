package consoleprinter;

import regexutils.SimpleWordCounter;
import stopwords.StopWordReader;

import java.util.Scanner;

public class WordCountProcessor {

    private String welcomeText;
    private String outputText;
    private StopWordReader stopWordReader;

    public WordCountProcessor(String welcomeText, String outputText, StopWordReader stopWordReader){
        this.welcomeText = welcomeText;
        this.outputText = outputText;
        this.stopWordReader = stopWordReader;
    }

    public void process(){
        printWelcomeMessage();
        WordCounter wordCounter = new SimpleWordCounter(readUserInput(), stopWordReader.getStopWords());
        printResultMessage(String.valueOf(wordCounter.countWords()));
    }

    private void printWelcomeMessage(){
        System.out.print(this.welcomeText);
    }

    private void printResultMessage(String result){
        System.out.printf("%s%s", this.outputText, result);
        System.out.println();
    }

    private String readUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
