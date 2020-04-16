import java.io.IOException;
import java.util.List;

public class App {

  private WordCounterInputReader wordCounterInputReader =new WordCounterInputReader();
  private WordCounter wordCounter = new WordCounter(wordCounterInputReader);

  public static void main(String[] args) throws IOException {
    App app = new App();
    app.start(args);
  }

  private void start(String[] args) throws IOException {
    String text = getText(args);
    int validWordsCount = wordCounter.getWordsCount(text);
    List<String> uniqueWords = wordCounter.getUniqueWords(text);
    wordCounter.displayResult(validWordsCount, uniqueWords.size());
  }

  private String getText(String[] args) throws IOException {
    String text;
    if (args.length == 0) {
      text = wordCounterInputReader.inputText();
    } else {
      text = wordCounterInputReader.readStartFile(args[0]);
    }
    return text;
  }

}