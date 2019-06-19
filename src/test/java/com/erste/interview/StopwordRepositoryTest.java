package com.erste.interview;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.junit.Test;

public class StopwordRepositoryTest {

  private final StopwordRepository repository;

  public StopwordRepositoryTest() throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URI uri = classLoader.getResource("stopwords.txt").toURI();
    repository = new StopwordRepository(Paths.get(uri));
  }

  @Test
  public void testWordsFromTestFileShouldReturnTrue() {
    assertTrue(repository.isStopword("the"));
    assertTrue(repository.isStopword("a"));
    assertTrue(repository.isStopword("on"));
    assertTrue(repository.isStopword("off"));
  }

  @Test
  public void testWordsNotInTestFileShouldReturnFalse() {
    assertFalse(repository.isStopword("Mary"));
    assertFalse(repository.isStopword("had"));
    assertFalse(repository.isStopword("lamb"));
  }
}