import java.io.*;
import java.util.Arrays;

public class WordCountMain {

    private static final String INDEX_FLAG = "-index";
    private static final String DICTIONARY_FLAG = "-dictionary=";

    boolean showIndex;
    String fileName;
    String dictionaryName;
    private AbstractWordCount counter;

    static PrintStream outputStream = System.out;

    public static void main(String[] args) throws IOException {
        WordCountMain app = new WordCountMain();

        app.handleArguments(args);
        if (app.fileName != null) {
            // read input from file
            app.counter = new FileWordCount(app.fileName, app.dictionaryName);
            app.processAndPrintResult();
        } else {
            // get input from terminal
            for (;;) {
                System.out.print("Enter text: ");
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String line = input.readLine();
                if (line == null || line.length() == 0) {
                    break;
                }
                app.counter = new StdInWordCount(Arrays.asList(line), app.dictionaryName);
                app.processAndPrintResult();
            }
        }
    }

    void processAndPrintResult() throws IOException {
        counter.doProcessing();
        outputStream.printf("Number of words %d, unique %d, average word length: %5.2f characters%n", counter.getTotalWords(), counter.getUniqueWords(), counter.getAverageLength());
        if (showIndex) {
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
