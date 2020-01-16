package processor;

public abstract class WordCountOrchestrator {

    private String outputText = "Number of words: ";
    StopWordReader stopWordReader;

    void printResultMessage(String result){
        System.out.printf("%s%s", this.outputText, result);
        System.out.println();
    }

    abstract public void process();
}
