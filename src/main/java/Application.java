import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter(new StopWordReader());
        WordInputReader wordInputReader;
        File inputFile;

        if (args.length > 0) {
            inputFile = new File(args[0]);
            if (inputFile.exists()) {
                wordInputReader = new WordInputFileReader(inputFile);
            } else {
                wordInputReader = new ConsoleInputReader();
            }
        } else {
            wordInputReader = new ConsoleInputReader();
        }

        String text = wordInputReader.processInput();
        System.out.println("Number of words: " + wordCounter.countWords(wordCounter.splitText(text)));
    }
}
