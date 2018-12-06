import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {

    /**
     * @param args
     */
    public static void main (String[] args){
        System.out.println("Please enter a text:");
        Scanner scanner = new Scanner(System.in);

        final String words = scanner.next();
        final String[] wordSet = WordCount.extractWords(words);

        System.out.println("Number of Words:" + wordSet.length);
    }

    /**
     * @param words
     * @return
     */
    private static String[] extractWords(String words) {
        /*
         * taken from
         * https://stackoverflow.com/questions/6020384/create-array-of-regex-matches
         */
        List<String> allMatches = new ArrayList<>();
        Matcher m = Pattern.compile("(a-zA-Z)+")
                .matcher(words);
        while (m.find()) {
            allMatches.add(m.group());
        }


        return allMatches.toArray(new String[0]);
    }
}