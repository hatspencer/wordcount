import org.junit.Assert;
import org.junit.Test;

public class FooTest {

  @Test
  public void splitterTest(){
    String str = "word wor4r 75";
    Foo foo = new Foo();
    int result = foo.countWords(str);
    Assert.assertEquals(result, 1);
  }

}
