import processor.*;
import stopwords.StopWordsFileReader;
import wordcounter.SimpleWordCounter;

public class WordCountApp {

    public static void main(String[] args){
        WordCountOrchestrator orchestrator;
        StopWordReader stopWordReader = new StopWordsFileReader();
        WordCounter wordCounter = new SimpleWordCounter(stopWordReader.getStopWords());


        if(args.length == 0){
            orchestrator = new ConsoleInputOrchestrator(stopWordReader, wordCounter);
        } else {
            orchestrator = new FileInputOrchestrator(stopWordReader, wordCounter, args[0]);
        }
        orchestrator.process();
    }
}
