import input.UserInputFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static List<String> filterUsersInput(List<String> userInput) {
        List<String> filteredList = new ArrayList<String>(userInput);
        Iterator<String> interator = filteredList.iterator();
        while (interator.hasNext()) {
            if (!interator.next().matches("[a-zA-Z-]+\\.?")) {
                interator.remove();
            }
        }
        return filteredList;
    }

    public static List<String> findWords(String inputArgs) {
        ExcludedWords excludedWords = ExcludedWords.getInstance();
        List<String> usersTextList = filterUsersInput(UserInputFactory.getUserInput(inputArgs).getInput());
        usersTextList.removeAll(excludedWords.getExcludedWords());
        return usersTextList;
    }

    public static List<String> findUnique(List<String> words) {
        return new ArrayList<>(new HashSet<>(words));
    }

    public static void main(String[] args) {
        String inputArgs = args.length > 0 ? args[0] : "";
        List<String> words = findWords(inputArgs);
        List<String> uniqueWords = findUnique(words);
        System.out.println("Number of words: " + words.size() + ", unique: " + uniqueWords.size());
    }
}
