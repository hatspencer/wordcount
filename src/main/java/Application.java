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
                wordInputReader = new WordInputConsoleReader();
            }

            String text = wordInputReader.processInput();
            String[] words = wordCounter.splitTextAtWhitespaceAndHyphen(text);
            System.out.printf("Number of words: %d, unique: %d",
                    wordCounter.countWords(words),
                    wordCounter.countDistinctWords(words));

        } catch (IOException e) {
            System.out.println("IOError occurred");
            System.exit(1);
        }
    }
}
