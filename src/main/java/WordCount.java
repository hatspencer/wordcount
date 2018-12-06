import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {

    public static void main (String[] args){
        System.out.println("Please enter a text:");
        Scanner scanner = new Scanner(System.in);

        final String words = scanner.next();

        final WordExtractor wordExtractor = new WordExtractor(words);

        System.out.println("Number of Words:" + wordExtractor.getWords().length);
    }

}

class WordExtractor {

    private String words;

    private String[] wordSet;

    public WordExtractor(String words) {
        this.words = words;


    }

    private void extractWords() {
        Pattern wordPattern = Pattern.compile("(a-zA-Z)+");
        Matcher wordMatcher = wordPattern.matcher(this.words);

        this.wordSet = wordPattern.split("\\s");
    }

    public String[] getWords() {
        return this.wordSet;
    }

}