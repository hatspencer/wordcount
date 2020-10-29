import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter(new StopWordReader());
        WordInputReader wordInputReader = new WordInputReader(new File("src/main/resources/input.old.txt"), new Scanner(System.in));
        String text = wordInputReader.processInput();

        System.out.println("Number of words: " + wordCounter.countWords(wordCounter.splitText(text)));
    }
}
