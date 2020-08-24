import java.io.IOException;

public class WordCountMain {

    public static void main(String[] args) throws IOException {
        AbstractWordCount counter;
        if (args.length == 1) {
            // read input from file
            counter = new FileWordCount(args[0]);
        } else {
            // get input from terminal
            counter = new StdInWordCount();
        }
        counter.doProcessing();
        System.out.printf("Number of words %d, unique %d%n", counter.getTotalWords(), counter.getUniqueWords());
    }
}
