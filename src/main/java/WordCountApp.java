import processor.ConsoleInputOrchestrator;
import processor.FileInputOrchestrator;
import processor.StopWordReader;
import processor.WordCountOrchestrator;
import stopwords.StopWordsFileReader;

public class WordCountApp {

    public static void main(String[] args){
        WordCountOrchestrator orchestrator;
        StopWordReader stopWordReader = new StopWordsFileReader();

        if(args.length == 0){
            orchestrator = new ConsoleInputOrchestrator(stopWordReader);
        } else {
            orchestrator = new FileInputOrchestrator(stopWordReader, args[0]);
        }
        orchestrator.process();
    }
}
