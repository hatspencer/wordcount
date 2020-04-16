import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

  String path = "stopwords.txt";
  WordCounter wordCounter = new WordCounter();

  @Test
  public void invalidCharactersTest() throws IOException {
    String invalidText1 = "word wor4r 75";
    int validWordsCount = wordCounter.countWords(invalidText1, path);
    Assert.assertEquals(1, validWordsCount);

    String invalidText2 = "wor1 qor2 dse3";
    validWordsCount = wordCounter.countWords(invalidText2, path);
    Assert.assertEquals(0, validWordsCount);

    String invalidText3 = " hff jggj kgg ";
    validWordsCount= wordCounter.countWords(invalidText3, path);
    Assert.assertEquals(3, validWordsCount);

    String invalidText4 = "hff'[- hggg ty*/`";
    validWordsCount= wordCounter.countWords(invalidText4, path);
    Assert.assertEquals(1, validWordsCount);
  }

  @Test
  public void stopWordsTest() throws IOException {
    String oneStopWord = "Mary had a little lamb";
    int validWords = wordCounter.countWords(oneStopWord, path);
    Assert.assertEquals(4, validWords);

    String twoStopWords = "Mary a the lamb";
    validWords = wordCounter.countWords(twoStopWords, path);
    Assert.assertEquals(2, validWords);
  }

  @Test
  public void readFileTest() throws IOException {
    List<String> fileContent = wordCounter.readFile(path);
    Assert.assertEquals(fileContent.size(), 4);
  }

}
