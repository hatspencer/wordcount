package kata.wordcount;

public class WordCountApp {

    private WordCounter wordCounter = new WordCounter();
    private InputReader inputReader = new InputReader();
    private OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) {
        WordCountApp app = new WordCountApp();
        app.count();
    }

    private void count() {
        String inputText = inputReader.getInput();
        long numberOfWords = wordCounter.count(inputText);
        outputWriter.writeOutput(numberOfWords);
    }

}
