import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordCounterInputReader {

  private final static String stopWordsFilePath = "stopwords.txt";

  public String inputText() throws IOException {
    System.out.print("Enter text: ");
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
    return reader.readLine();
  }

  public String readStartFile(String startFilePath) throws IOException {
    File file = new File(startFilePath);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    StringBuilder stringBuilder = new StringBuilder();
    while ((st = br.readLine()) != null) {
      stringBuilder.append(st).append(" ");
    }
    return stringBuilder.toString().replaceAll("\\s+$", "");
  }

  public List<String> readStopWordsFile() throws IOException {
    File file = new File(stopWordsFilePath);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    List<String> textContent = new ArrayList<>();
    while ((st = br.readLine()) != null) {
      textContent.add(st);
    }
    return textContent;
  }

}
