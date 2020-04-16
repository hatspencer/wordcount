import java.io.IOException;
import java.util.List;

public class App {

  public static void main(String[] args) throws IOException {
    WordCounter wordCounter = new WordCounter();
    String stopWordsFilePath = "stopwords.txt";
    String text;
    String startFilePath;

    if(args.length==0){
      text = wordCounter.inputText();
    }
    else {
      startFilePath = args[0];
      text = wordCounter.readStartFile(startFilePath);
    }

    int validWordsCount = wordCounter.getWordsCount(text, stopWordsFilePath);
    List<String> uniqueWords = wordCounter.getUniqueWords(text, stopWordsFilePath);

    wordCounter.displayResult(validWordsCount, uniqueWords.size());
  }
}