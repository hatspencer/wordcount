import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

  public String inputText() throws IOException {
    System.out.print("Enter text: ");
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
  }

  public String readStartFile(String pathname) throws IOException {
    File file = new File(pathname);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    StringBuilder stringBuilder = new StringBuilder();
    while ((st = br.readLine()) != null) {
      stringBuilder.append(st).append(" ");
    }
    return stringBuilder.toString().replaceAll("\\s+$", "");
  }

  public int getWordsCount(String text, String pathname) throws IOException {
    List<String> validWords = getValidWords(text, pathname);
    return validWords.size();
  }

  public List<String> getUniqueWords(String text, String pathname) throws IOException{
    List<String> validWords = getValidWords(text, pathname);
    List<String> uniqueWords =  new ArrayList<>();
    for(String validWord : validWords){
      if(!uniqueWords.contains(validWord)){
        uniqueWords.add(validWord);
      }
    }
    return uniqueWords;
  }

  private List<String> getValidWords(String text, String pathname) throws IOException {
    String str1 = text.replace(".", "").replace("-", " ");
    String[] words = str1.split(" ");
    List<String> wordsToExclude = readStopWordsFile(pathname);
    return wordsFilter(words, wordsToExclude);
  }

  public List<String> readStopWordsFile(String pathName) throws IOException {
    File file = new File(pathName);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    List<String> textContent = new ArrayList<>();
    while ((st = br.readLine()) != null) {
      textContent.add(st);
    }
    return textContent;
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


