import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FooTest {

  Foo foo = new Foo();
  String path = "stopwords.txt";

  @Test
  public void splitterTest() throws IOException {
    String str1 = "word wor4r 75";

    int result = foo.countWords(str1, path);
    Assert.assertEquals(1, result);

    String str2 = "wor1 qor2 dse3";
    result = foo.countWords(str2, path);
    Assert.assertEquals(0, result);

    String str3 = " hff jggj kgg ";
    result=foo.countWords(str3, path);
    Assert.assertEquals(3, result);

    String str4 = "hff'[- hggg ty*/`";
    result=foo.countWords(str4, path);
    Assert.assertEquals(1, result);

    String str5 = "Mary had a little lamb";
    result = foo.countWords(str5, path);
    Assert.assertEquals(4, result);

    String str6 = "Mary a the lamb";
    result = foo.countWords(str6, path);
    Assert.assertEquals(2, result);
  }

  @Test
  public void readFileTest() throws IOException {
    List<String> fileContent = foo.readFile(path);
    Assert.assertEquals(fileContent.size(), 4);
  }

}
