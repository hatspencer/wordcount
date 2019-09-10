import java.util.*;

public class WordCountApplication {
    private static boolean shouldPrintIndex;
    private static boolean hasFilename;
    private static String filename;
    static String dictionaryFilename;
    static boolean shouldCheckAgainstDictionary;

    public static void main(String[] args) {
        handleOptionalArguments(args);
        String input;
        if (hasFilename) {
            input = getInput(filename);
        } else {
            input = getInput();
        }
        WordCounter counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        System.out.println("Number of words:" + numberOfWords + ", unique:" + numberOfUniqueWords + "; average word length: " + counter.getAverageWordLength() + " characters");
        if (shouldPrintIndex) {
            int numberOfUnknownWords = 0;
            List<Word> sortedWords = counter.getValidWords();
            for (Word sortedWord : sortedWords) {
                if(!sortedWord.isKnown()) numberOfUnknownWords++;
            }
            System.out.println("Index (Unknown: "+numberOfUnknownWords+"):");
            //noinspection unchecked
            Collections.sort(sortedWords);
            for (Word word : sortedWords) {
                System.out.println(word);
            }
        }
    }

    static void handleOptionalArguments(String... args) {
        List<String> arguments = new ArrayList<>(Arrays.asList(args));
        for (String argument : arguments) {
            if (argument.equals("-index")) shouldPrintIndex = true;
            else if (argument.contains("-dictionary")) {
                shouldCheckAgainstDictionary = true;
                dictionaryFilename = argument.split("=")[1];
            } else {
                hasFilename = true;
                filename = argument;
            }
        }
    }

    static String getInput(String... args) {
        String input;
        if (hasFilename) {
            input = FileUtils.getSentenceFromFile(filename);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter text:");
            input = in.nextLine();
        }
        return input;
    }
}
