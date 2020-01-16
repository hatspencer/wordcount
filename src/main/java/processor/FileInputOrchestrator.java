package processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputOrchestrator extends WordCountOrchestrator{

    private String filename;
    private WordCounter wordCounter;

    public FileInputOrchestrator(StopWordReader stopWordReader, WordCounter wordCounter, String filename){
        this.stopWordReader = stopWordReader;
        this.filename = filename;
        this.wordCounter = wordCounter;
    }

    @Override
    public void process(){
        printResultMessage(String.valueOf(wordCounter.countWords(readUserInput())));
    }

    private String readUserInput(){
        try {
            return String.join(" ", Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println("Could not read input file.");
            return "";
        }
    }
}
