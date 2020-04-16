import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    Foo foo = new Foo();
    String path = "stopwords.txt";

    String text = foo.inputText();
    int validWordsCount = foo.countWords(text, path);

    foo.displayResult(validWordsCount);
  }
}