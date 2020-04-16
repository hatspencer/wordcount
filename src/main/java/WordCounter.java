import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

  public String inputText() throws IOException {
    System.out.println("Enter text: ");
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
  }

  public int countWords(String text, String pathname) throws IOException {
    String[] words = text.split(" ");
    List<String> wordsToExclude = readStopWordsFile(pathname);
    List<String> validWords = wordsFilter(words, wordsToExclude);
    return validWords.size();
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

  public String readStartFile(String pathname) throws IOException {
    File file = new File(pathname);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    StringBuilder stringBuilder = new StringBuilder();
    while ((st = br.readLine()) != null) {
      stringBuilder.append(st).append(" ");
    }
    String s = stringBuilder.toString();
    return s.replaceAll("\\s+$", "");
  }

  private List<String> wordsFilter(String[] text, List<String> wordsToExclude) {
    List<String> validWords = getOnlyLettersWords(text);
    return filterNotRelevantWords(wordsToExclude, validWords);
  }

  private List<String> getOnlyLettersWords(String[] text) {
    List<String> validWords = new ArrayList<>();
    for (String s : text) {
      if (s.matches("[a-zA-Z]+")) {
        validWords.add(s);
      }
    }
    return validWords;
  }

  private List<String> filterNotRelevantWords(List<String> wordsToExclude,
      List<String> validWords) {
    List<String> relevantWords = new ArrayList<>();
    for (String validWord : validWords) {
      if (!wordsToExclude.contains(validWord)) {
        relevantWords.add(validWord);
      }
    }
    return relevantWords;
  }

  public void displayResult(int result) {
    System.out.printf("Number of words: %s", result);
  }
}


