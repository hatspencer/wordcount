
public class WordsCounter {
    public int countWords(String input) {
        String[] splittedGroups = input.split("\\s+");
        int wordCnt = 0;
        for (String splittedGroup : splittedGroups) {
            if (splittedGroup.matches("[a-zA-Z]+\\.?")) {
                wordCnt++;
            }
        }
        return wordCnt;
    }
}
