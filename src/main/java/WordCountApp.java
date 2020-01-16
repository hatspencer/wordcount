import processor.*;
import stopwords.StopWordsFileReader;
import userinput.ConsoleInputReader;
import userinput.FileInputReader;
import userinput.UserInputReader;
import wordcounter.SimpleWordCounter;

public class WordCountApp {

    public static void main(String[] args){
        StopWordReader stopWordReader = new StopWordsFileReader();
        WordCounter wordCounter = new SimpleWordCounter(stopWordReader.getStopWords("stopwords.txt"));
        UserInputReader reader;

        if(args.length == 0){
            reader = new ConsoleInputReader();
        } else {
            reader = new FileInputReader(args[0]);
        }

        new WordCountOrchestrator(reader, wordCounter).process();
    }
}
