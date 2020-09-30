public class CountService {

    public int countWords(String text) {
        String[] textParts = text.split("\\s");
        int count = 0;

        for (String word: textParts) {
            if (word.matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }
}
