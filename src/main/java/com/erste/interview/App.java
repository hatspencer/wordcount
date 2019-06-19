package com.erste.interview;

import com.erste.interview.inputstring.InputStringProvider;
import com.erste.interview.inputstring.InputStringProviderFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class App {

  public static void main(String[] args) {
    WordCounterImpl wordCounter = new WordCounterImpl(createStopwordRepository());
    InputStringProviderFactory inputStringProviderFactory = new InputStringProviderFactory(args);
    InputStringProvider inputStringProvider = inputStringProviderFactory.createInputStringProvider();
    String inputString = inputStringProvider.provideInputString();
    final WordCountResultDto resultDto = wordCounter.countWords(inputString);
    System.out.println(String.format("Number of words: %d, unique: %d", resultDto.getWordCount(), resultDto.getUniqueWordCount()));
  }

  private static StopwordRepository createStopwordRepository() {
    ClassLoader classLoader = App.class.getClassLoader();
    URI uri = null;
    try {
      uri = classLoader.getResource("stopwords.txt").toURI();
    } catch (URISyntaxException e) {
      throw new IllegalStateException("Illegal URI", e);
    }
    return new StopwordRepository(Paths.get(uri));
  }

}
