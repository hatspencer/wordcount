package solver;

public class WordCounter {

    public int countWords(String text) {
        String[] arr = text.split("\\s+");
        int wordCount = arr.length;
        for (String word: arr) {
            if (!word.matches("[a-zA-Z]+")) {
                wordCount--;
            }
        }
        return wordCount;
    }
}
