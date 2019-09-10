import java.util.*;

class WordCounter {
    List<Word> getValidWords() {
        return validWords;
    }

    private List<Word> validWords;
    private String invalidWordsFilename;
    private String dictionaryFilename;
    WordCounter(String input, String invalidWordsFilename, String dictionaryFilename) {
        validWords = new ArrayList<>();
        this.invalidWordsFilename = invalidWordsFilename;
        this.dictionaryFilename = dictionaryFilename;
        processInputAndFillingValidWordsList(input);
    }

    private void processInputAndFillingValidWordsList(String input) {
        String[] wordsInInput = input.split(" ");
        Dictionary invalidWords = new Dictionary(invalidWordsFilename);
        Dictionary dictionary = new Dictionary(dictionaryFilename);
        for (String word : wordsInInput) {
            if (!invalidWords.hasWord(word.toLowerCase()) && word.toLowerCase().matches("[a-z,\\-,.]+"))
                validWords.add(new Word(word, dictionary.hasWord(word)));
        }
    }

    int getWordsCountInText() {
        return validWords.size();
    }

    int getUniqueWordsCountInText() {
        Set<String> uniques=new HashSet<>();
        for (Word word : validWords) {
            uniques.add(word.getWord());
        }
        return uniques.size();
    }

    double getAverageWordLength() {
        double avgLength = 0;
        Set<String> uniqueWords=new HashSet<>();
        for (Word word : validWords) {
            uniqueWords.add(word.getWord());
        }
        if (uniqueWords.size() == 0) return 0.0;
        for (String word : uniqueWords) {
            avgLength += word.length();
        }
        return avgLength / uniqueWords.size();
    }
}
