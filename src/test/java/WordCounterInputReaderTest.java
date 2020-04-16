import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterInputReaderTest {
  WordCounterInputReader wordCounterInputReader =  new WordCounterInputReader();
  String startFilePath = "startfile.txt";

  @Test
  public void readStopWordsFileTest() throws IOException {
    List<String> fileContent = wordCounterInputReader.readStopWordsFile();
    Assert.assertEquals(fileContent.size(), 4);
  }

  @Test
  public void readStartFileTest() throws IOException {
    String startFileContent = wordCounterInputReader.readStartFile(startFilePath);
    Assert.assertEquals(startFileContent, "Mary had a little lamb");
  }

}
