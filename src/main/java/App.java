import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    WordCounter wordCounter = new WordCounter();
    String path = "stopwords.txt";

    String text = wordCounter.inputText();
    int validWordsCount = wordCounter.countWords(text, path);

    wordCounter.displayResult(validWordsCount);
  }
}