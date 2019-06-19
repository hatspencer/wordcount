package com.erste.interview;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterImplTest {

  private WordCounter wordCounter = new WordCounterImpl();

  @Test
  public void testMaryHadALittleLamb() {
    int words = wordCounter.countWords("Mary had a little lamb");
    Assert.assertEquals(5, words);
  }

  @Test
  public void testMaryHadALittleLambDuplicateWhitespaces() {
    int words = wordCounter.countWords("Mary    had  a \n\n\nlittle \t\t\t\tlamb");
    Assert.assertEquals(5, words);
  }

  @Test
  public void testEmptyString() {
    int words = wordCounter.countWords("");
    Assert.assertEquals(0, words);
  }

  @Test
  public void testSingleWord() {
    int words = wordCounter.countWords("Mary");
    Assert.assertEquals(1, words);
  }

  @Test
  public void testWordsWithInvalidCharacters() {
    int words = wordCounter.countWords("Mary h0d a little l@mb");
    Assert.assertEquals(3, words);
  }
}