import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

  String startFilePath = "startfile.txt";
  WordCounterInputReader wordCounterInputReader =  new WordCounterInputReader();
  WordCounter wordCounter = new WordCounter(wordCounterInputReader);

  @Test
  public void invalidCharactersTest() throws IOException {
    String invalidText1 = "word wor4r 75";
    int validWordsCount = wordCounter.getWordsCount(invalidText1);
    Assert.assertEquals(1, validWordsCount);

    String invalidText2 = "wor1 qor2 dse3";
    validWordsCount = wordCounter.getWordsCount(invalidText2);
    Assert.assertEquals(0, validWordsCount);

    String invalidText3 = " hff jggj kgg ";
    validWordsCount= wordCounter.getWordsCount(invalidText3);
    Assert.assertEquals(3, validWordsCount);

    String invalidText4 = "hff'[- hggg ty*/`";
    validWordsCount= wordCounter.getWordsCount(invalidText4);
    Assert.assertEquals(1, validWordsCount);
  }

  @Test
  public void stopWordsTest() throws IOException {
    String oneStopWord = "Mary had a little lamb";
    int validWords = wordCounter.getWordsCount(oneStopWord);
    Assert.assertEquals(4, validWords);

    String twoStopWords = "Mary a the lamb";
    validWords = wordCounter.getWordsCount(twoStopWords);
    Assert.assertEquals(2, validWords);
  }

  @Test
  public void countWordsFromStartFile() throws IOException{
    String startFileContent = wordCounterInputReader.readStartFile(startFilePath);
    int validWordsCount = wordCounter.getWordsCount(startFileContent);
    Assert.assertEquals(4, validWordsCount);
  }

  @Test
  public void uniqueWordsTest() throws IOException{
    String str = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

    int validWordsCount = wordCounter.getWordsCount(str);
    Assert.assertEquals(9, validWordsCount);

    List<String> uniqueWords = wordCounter.getUniqueWords(str);
    Assert.assertEquals(7, uniqueWords.size());
  }

}
