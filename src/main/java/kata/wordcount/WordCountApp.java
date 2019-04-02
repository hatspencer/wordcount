package kata.wordcount;

public class WordCountApp {

    private WordCounter wordCounter = new WordCounter();
    private InputReader inputReader = new InputReader();

    public static void main(String[] args) {

        WordCountApp app = new WordCountApp();
        String inputText = app.inputReader.getInput();
        long numberOfWords = app.wordCounter.count(inputText);
        System.out.println(String.format("Number of words: %s", numberOfWords));
    }


}
