import java.util.ArrayList;
import java.util.List;

public class Foo {

  //console input
  
  public int countWords(String text) {
    String[] words = text.split(" ");
    List<String> validWords = wordsFilter(words);
    return validWords.size();
  }

  private List<String> wordsFilter(String[] words) {
    List<String> validWords = new ArrayList<String>();
    for (String s : words) {
      if (s.matches("[a-zA-Z]+")) {
        validWords.add(s);
      }
    }
    return validWords;
  }

  //output to terminal
}
