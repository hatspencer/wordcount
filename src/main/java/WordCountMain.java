import java.io.IOException;

public class WordCountMain {

    boolean showIndex;
    String fileName;

    public static void main(String[] args) throws IOException {
        WordCountMain app = new WordCountMain();
        AbstractWordCount counter;
        app.handleArguments(args);
        if (app.fileName != null) {
            // read input from file
            counter = new FileWordCount(app.fileName);
        } else {
            // get input from terminal
            counter = new StdInWordCount();
        }
        counter.doProcessing();
        System.out.printf("Number of words %d, unique %d, average word length: %5.2f characters%n", counter.getTotalWords(), counter.getUniqueWords(), counter.getAverageLength());
        if (app.showIndex) {
            printIndex(counter);
        }
    }

    void handleArguments(String[] args) {
        for (String arg : args) {
            if (arg.equals("-index")) {
                showIndex = true;
            } else if (!arg.startsWith("-")) {
                if (fileName != null) {
                    System.out.printf("invalid argument %s%n", arg);
                } else {
                    fileName = arg;
                }
            } else {
                System.out.printf("invalid option %s%n", arg);
            }
        }
    }

    private static void printIndex(AbstractWordCount counter) {
        System.out.println("Index:");
        for (String word : counter.getAllWords()) {
            System.out.println(word);
        }
    }
}
