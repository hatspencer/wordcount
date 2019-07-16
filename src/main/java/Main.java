import input.UserInputFactory;

import java.util.*;

public class Main {


    public static List<String> filterUsersInput(List<String> userInput) {
        List<String> filteredList = new ArrayList<String>(userInput);
        Iterator<String> interator = filteredList.iterator();
        while (interator.hasNext()) {
            if (!interator.next().matches("[a-zA-Z]+\\.?")) {
                interator.remove();
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        String inputPath = args.length > 0 ? args[0] : "";
        ExcludedWords excludedWords = ExcludedWords.getInstance();
        List<String> usersTextList = filterUsersInput(UserInputFactory.getUserInput(inputPath).getInput());
        usersTextList.removeAll(excludedWords.getExcludedWords());
        System.out.println("Number of words: " + usersTextList.size());
    }
}
