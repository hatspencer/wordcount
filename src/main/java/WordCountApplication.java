import java.util.*;

public class WordCountApplication {
    static String input;
    static WordCounter counter;

    public static void main(String[] args) {
        ArgumentHandler argumentHandler = new ArgumentHandler(args);

        if (argumentHandler.isFilenameProvided()) {
            input = FileUtils.getSentenceFromFile(argumentHandler.getFilename());
            counter = new WordCounter(input, "stopwords.txt", argumentHandler.getDictionaryFilename());
            printResult();
        } else {
            while (!(input = getInputFromCommandLine()).equals("")) {
                counter = new WordCounter(input, "stopwords.txt", argumentHandler.getDictionaryFilename());
                printResult();
                if (argumentHandler.isIndexFlagProvided()) {
                    printIndex();
                }
            }
        }
    }

    static void printResult() {
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        System.out.println("Number of words:" + numberOfWords + ", unique:" + numberOfUniqueWords + "; average word length: " + counter.getAverageWordLength() + " characters");

    }

    static void printIndex() {
        int numberOfUnknownWords = 0;
        List<Word> words = counter.getValidWords();
        for (Word sortedWord : words) {
            if (!sortedWord.isKnown()) numberOfUnknownWords++;
        }
        System.out.println("Index (Unknown: " + numberOfUnknownWords + "):");
        //noinspection unchecked
        Collections.sort(words);
        for (Word word : words) {
            System.out.println(word);
        }
    }

    static String getInputFromCommandLine() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text:");
        return in.nextLine();
    }
}
