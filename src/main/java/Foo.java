import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Foo {

  public String inputText() throws IOException {
    System.out.println("Enter text: ");
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
  }

  public int countWords(String text) {
    String[] words = text.split(" ");
    List<String> validWords = wordsFilter(words);
    return validWords.size();
  }

  private List<String> wordsFilter(String[] words) {
    List<String> validWords = new ArrayList<>();
    for (String s : words) {
      if (s.matches("[a-zA-Z]+")) {
        validWords.add(s);
      }
    }
    return validWords;
  }

  public void displayResult(int result) {
    String s = "Number of words: " + result;
    System.console().writer().println(s);
  }

}
