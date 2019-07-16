import java.util.*;

public class Main {

    private static List<String> readUsersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        return new ArrayList<String>(Arrays.asList(text.trim().split("\\s+")));
    }

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
        ExcludedWords excludedWords = ExcludedWords.getInstance();
        List<String> usersTextList = filterUsersInput(readUsersInput());
        usersTextList.removeAll(excludedWords.getExcludedWords());
        System.out.println("Number of words: " + usersTextList.size());
    }
}
