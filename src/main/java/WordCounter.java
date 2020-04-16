import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

  private WordCounterInputReader wordCounterInputReader;

  public WordCounter(WordCounterInputReader wordCounterInputReader) {
    this.wordCounterInputReader = wordCounterInputReader;
  }

  public int getWordsCount(String text) throws IOException {
    List<String> validWords = getValidWords(text);
    return validWords.size();
  }

  public List<String> getUniqueWords(String text) throws IOException{
    List<String> validWords = getValidWords(text);
    List<String> uniqueWords =  new ArrayList<>();
    for(String validWord : validWords){
      if(!uniqueWords.contains(validWord)){
        uniqueWords.add(validWord);
      }
    }
    return uniqueWords;
  }

  private List<String> getValidWords(String text) throws IOException {
    String str1 = text.replace(".", "").replace("-", " ");
    String[] words = str1.split(" ");
    List<String> wordsToExclude = wordCounterInputReader.readStopWordsFile();
    return wordsFilter(words, wordsToExclude);
  }

  private List<String> wordsFilter(String[] text, List<String> wordsToExclude) {
    List<String> validWords = nonAlphabeticalWordsFilter(text);
    return stopWordsFilter(wordsToExclude, validWords);
  }

  private List<String> nonAlphabeticalWordsFilter(String[] text) {
    List<String> validWords = new ArrayList<>();
    for (String s : text) {
      if (s.matches("[a-zA-Z]+")) {
        validWords.add(s);
      }
    }
    return validWords;
  }

  private List<String> stopWordsFilter(List<String> wordsToExclude,
      List<String> validWords) {
    List<String> relevantWords = new ArrayList<>();
    for (String validWord : validWords) {
      if (!wordsToExclude.contains(validWord)) {
        relevantWords.add(validWord);
      }
    }
    return relevantWords;
  }

  public void displayResult(int validWords, int uniqueWords) {
    System.out.printf("Number of words: %s, unique: %s ", validWords, uniqueWords);
  }
}


