package processor;

import wordcounter.SimpleWordCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputOrchestrator extends WordCountOrchestrator{

    private String filename;

    public FileInputOrchestrator(StopWordReader stopWordReader, String filename){
        this.stopWordReader = stopWordReader;
        this.filename = filename;
    }

    @Override
    public void process(){
        WordCounter wordCounter = new SimpleWordCounter(readUserInput(), stopWordReader.getStopWords());
        printResultMessage(String.valueOf(wordCounter.countWords()));
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
