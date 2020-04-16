import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    WordCounter wordCounter = new WordCounter();
    String stopWordsFilePath = "stopwords.txt";
    String startFilePath = "startfile.txt";

    String text = wordCounter.readStartFile(startFilePath);
    int validWordsCount = wordCounter.countWords(text, stopWordsFilePath);

    wordCounter.displayResult(validWordsCount);
  }
}