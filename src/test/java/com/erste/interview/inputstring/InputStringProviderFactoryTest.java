package com.erste.interview.inputstring;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;

public class InputStringProviderFactoryTest {

  @Test
  public void testEmptyArgsShouldCreateConsoleProvider() {
    final InputStringProviderFactory factory = new InputStringProviderFactory(new String[]{});
    final InputStringProvider inputStringProvider = factory.createInputStringProvider();
    Assert.assertEquals(ConsoleInputStringProvider.class, inputStringProvider.getClass());
  }

  @Test
  public void testSingleArgShouldCreateFileProvider() throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URI uri = classLoader.getResource("stopwords.txt").toURI();
    final Path absolutePath = Paths.get(uri).toAbsolutePath();
    final InputStringProviderFactory factory = new InputStringProviderFactory(new String[]{absolutePath.toString()});
    final InputStringProvider inputStringProvider = factory.createInputStringProvider();
    Assert.assertEquals(FileInputStringProvider.class, inputStringProvider.getClass());
  }

}