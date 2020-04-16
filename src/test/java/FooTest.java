import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class FooTest {

  @Test
  public void splitterTest() throws IOException {
//    String str = "word wor4r 75";
    Foo foo = new Foo();
    String text = foo.inputText();
    int result = foo.countWords(text);
    Assert.assertEquals(result, 1);
  }

}
