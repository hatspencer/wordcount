import java.io.IOException;
import java.util.List;

public class App {

  public static void main(String[] args) throws IOException {
    WordCounter wordCounter = new WordCounter();
    String stopWordsFilePath = "stopwords.txt";
    String startFilePath = "startfile.txt";

//    String text = wordCounter.readStartFile(startFilePath);
    String text = wordCounter.inputText();
    int validWordsCount = wordCounter.getWordsCount(text, stopWordsFilePath);
    List<String> uniqueWords = wordCounter.getUniqueWords(text, stopWordsFilePath);

    wordCounter.displayResult(validWordsCount, uniqueWords.size());
  }
}