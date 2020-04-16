import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FooTest {

  Foo foo = new Foo();

  @Test
  public void splitterTest() {
    String str1 = "word wor4r 75";
    int result = foo.countWords(str1);
    Assert.assertEquals(result, 1);

    String str2 = "wor1 qor2 dse3";
    result = foo.countWords(str2);
    Assert.assertEquals(result, 0);

    String str3 = " hff jggj kgg ";
    result=foo.countWords(str3);
    Assert.assertEquals(result, 3);

    String str4 = "hff'[- hggg ty*/`";
    result=foo.countWords(str4);
    Assert.assertEquals(result, 1);
  }

  @Test
  public void readFileTest() throws IOException {
    String path = "stopwords.txt";
    List<String> fileContent = foo.readFile(path);
    Assert.assertEquals(fileContent.size(), 4);
  }

}
