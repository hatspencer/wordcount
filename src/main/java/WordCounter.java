import java.util.*;

class WordCounter {
    public List<String> getValidWords() {
        return validWords;
    }

    private List<String> validWords;

    WordCounter(String input) {
        validWords = new ArrayList<>();
        processInput(input);
    }
    private void processInput(String input) {
        String[] wordsInInput = input.split(" ");
        List<String> invalidWords = Arrays.asList(FileUtils.readWordsFromFile("stopwords.txt"));
        for (String s : wordsInInput) {
            if (!invalidWords.contains(s.toLowerCase()) && s.toLowerCase().matches("[a-z,\\-,.]+")) validWords.add(s);
        }
    }
    int getWordsCountInText() {
        return validWords.size();
    }
    int getUniqueWordsCountInText() {
        return new HashSet<>(validWords).size();
    }
    double getAverageWordLength(){
        double avgLength = 0;
        Set<String> uniqueWords = new HashSet<>(validWords);
        if(uniqueWords.size()==0) return 0.0;
        for (String word: uniqueWords) {
            avgLength += word.length();
        }
        return avgLength/uniqueWords.size();
    }
}
