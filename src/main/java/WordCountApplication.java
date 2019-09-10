import java.util.*;

public class WordCountApplication {

    public static void main(String[] args) {
        String input = getInput(args);
        WordCounter counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        System.out.print("Number of words:" + numberOfWords + ", unique:" + numberOfUniqueWords);
    }

    static String getInput(String... args){
        String input;
        if (args.length > 0) {
            String filename = args[0];
            input = FileUtils.getSentenceFromFile(filename);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter text:");
            input = in.nextLine();
        }
        return input;
    }
}
