package hiring;

import hiring.input.ConsoleTextProvider;

public class WordCountApp {

    public void run() {
        TextProvider textProvider = createConsoleTextProvider();
        String text = textProvider.provideText();
        WordCounter wordCounter = createBasicWordCounter();
        int count = wordCounter.countWords(text);
        printOutput(count);
    }

    private TextProvider createConsoleTextProvider() {
        return new ConsoleTextProvider();
    }

    private WordCounter createBasicWordCounter() {
        return new BasicWordCounter();
    }

    private void printOutput(int count) {
        System.out.printf("Number of words: %d\n", count);
    }

    public static void main(String[] args) {
        new WordCountApp().run();
    }
}
