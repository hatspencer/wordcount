package com.erste.interview.inputstring;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class FileInputStringProviderTest {

  private final FileInputStringProvider provider;

  public FileInputStringProviderTest() throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URI uri = classLoader.getResource("test-input-file.txt").toURI();
    provider = new FileInputStringProvider(Paths.get(uri));
  }

  @Test
  public void testFileIsReadCorrectly() {
    final String providedInputString = provider.provideInputString();
    Assert.assertEquals("Mary had a really little lamb", providedInputString);
  }

}