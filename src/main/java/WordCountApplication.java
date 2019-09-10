import java.util.*;

public class WordCountApplication {

    public static void main(String[] args) {
        List<String> arguments = Arrays.asList(args);
        boolean shouldPrintIndex = arguments.contains("-index");
        String input = getInput(arguments.get(arguments.size()-1));
        WordCounter counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        System.out.println("Number of words:" + numberOfWords + ", unique:" + numberOfUniqueWords + "; average word length: "+counter.getAverageWordLength()+" characters");
        if(shouldPrintIndex){
            System.out.println("Index:");
            List<String> sortedWords = counter.getValidWords();
            for(String word: sortedWords){
                System.out.println(word);
            }
        }
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
