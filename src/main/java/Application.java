import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
            WordCounter wordCounter = new WordCounter(new StopWordReader());
            WordInputReader wordInputReader;
            File inputFile;

            if (args.length > 0) {
                inputFile = new File(args[0]);
                wordInputReader = new WordInputFileReader(inputFile);
            } else {
                wordInputReader = new ConsoleInputReader();
            }

            String text = wordInputReader.processInput();
            System.out.println("Number of words: " + wordCounter.countWords(wordCounter.splitText(text)));

        } catch (IOException e) {
            System.out.println("IOError");
            System.exit(1);
        }
    }
}
