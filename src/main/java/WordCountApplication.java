import java.util.*;

public class WordCountApplication {

    public static void main(String[] args) {
        List<String> arguments = new ArrayList<>(Arrays.asList(args));
        boolean shouldPrintIndex = arguments.contains("-index");
        if (shouldPrintIndex) arguments.remove("-index");
        boolean hasFilename = arguments.size() == 1;
        String input;
        if (hasFilename) {
            input = getInput(arguments.get(0));
        } else {
            input = getInput();
        }
        WordCounter counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        System.out.println("Number of words:" + numberOfWords + ", unique:" + numberOfUniqueWords + "; average word length: " + counter.getAverageWordLength() + " characters");
        if (shouldPrintIndex) {
            System.out.println("Index:");
            List<Word> sortedWords = counter.getValidWords();
            //noinspection unchecked
            Collections.sort(sortedWords);
            for (Word word : sortedWords) {
                System.out.println(word);
            }
        }
    }

    static String getInput(String... args) {
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
