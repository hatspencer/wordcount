package hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountApp {

    public void run() {
        String text = readText();
        WordCounter wordCounter = createBasicWordCounter();
        int count = wordCounter.countWords(text);
        printOutput(count);
    }

    private WordCounter createBasicWordCounter() {
        return new BasicWordCounter();
    }

    // TODO Externalize?
    private String readText() {
        System.out.print("Enter text: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void printOutput(int count) {
        System.out.printf("Number of words: %d\n", count);
    }

    public static void main(String[] args) {
        new WordCountApp().run();
    }
}
