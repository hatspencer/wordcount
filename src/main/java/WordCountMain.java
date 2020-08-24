import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class WordCountMain {

    private static final String INDEX_FLAG = "-index";
    private static final String DICTIONARY_FLAG = "-dictionary=";

    boolean showIndex;
    String fileName;
    String dictionaryName;

    static PrintStream outputStream = System.out;

    public static void main(String[] args) throws IOException {
        WordCountMain app = new WordCountMain();
        AbstractWordCount counter;
        app.handleArguments(args);
        if (app.fileName != null) {
            // read input from file
            counter = new FileWordCount(app.fileName, app.dictionaryName);
        } else {
            // get input from terminal
            counter = new StdInWordCount(app.dictionaryName);
        }
        counter.doProcessing();
        outputStream.printf("Number of words %d, unique %d, average word length: %5.2f characters%n", counter.getTotalWords(), counter.getUniqueWords(), counter.getAverageLength());
        if (app.showIndex) {
            printIndex(counter);
        }
    }

    void handleArguments(String[] args) {
        for (String arg : args) {
            if (arg.equals(INDEX_FLAG)) {
                showIndex = true;
            } else if (arg.startsWith(DICTIONARY_FLAG)) {
                dictionaryName = arg.substring(DICTIONARY_FLAG.length());
            } else if (!arg.startsWith("-")) {
                if (fileName != null) {
                    outputStream.printf("invalid argument %s%n", arg);
                } else {
                    fileName = arg;
                }
            } else {
                outputStream.printf("invalid option %s%n", arg);
            }
        }
    }

    private static void printIndex(AbstractWordCount counter) {
        outputStream.println("Index:");
        for (String word : counter.getAllWords()) {
            outputStream.println(word);
        }
    }
}
