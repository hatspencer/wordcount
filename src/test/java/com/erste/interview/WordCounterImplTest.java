package com.erste.interview;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class WordCounterImplTest {

  private static final double DELTA = 0.001;
  private StopwordRepository stopwordRepository = Mockito.mock(StopwordRepository.class);
  private WordCounter wordCounter = new WordCounterImpl(stopwordRepository);

  @Before
  public void setUp() throws Exception {
    when(stopwordRepository.isStopword(anyString())).thenReturn(false);
  }

  @Test
  public void testMaryHadALittleLamb() {
    int words = wordCounter.countWords("Mary had a little lamb").getWordCount();
    Assert.assertEquals(5, words);
  }

  @Test
  public void testMaryHadALittleLambDuplicateWhitespaces() {
    int words = wordCounter.countWords("Mary    had  a \n\n\nlittle \t\t\t\tlamb").getWordCount();
    Assert.assertEquals(5, words);
  }

  @Test
  public void testEmptyString() {
    int words = wordCounter.countWords("").getWordCount();
    Assert.assertEquals(0, words);
  }

  @Test
  public void testSingleWord() {
    int words = wordCounter.countWords("Mary").getWordCount();
    Assert.assertEquals(1, words);
  }

  @Test
  public void testWordsWithInvalidCharacters() {
    int words = wordCounter.countWords("Mary h0d a little l@mb").getWordCount();
    Assert.assertEquals(3, words);
  }

  @Test
  public void testStopwordShouldNotBeCounted() {
    when(stopwordRepository.isStopword("a")).thenReturn(true);
    int words = wordCounter.countWords("Mary had a little lamb").getWordCount();
    Assert.assertEquals(4, words);
  }

  @Test
  public void testMultipleStopwordsShouldNotBeCounted() {
    when(stopwordRepository.isStopword("a")).thenReturn(true);
    when(stopwordRepository.isStopword("lamb")).thenReturn(true);
    int words = wordCounter.countWords("Mary had a little lamb").getWordCount();
    Assert.assertEquals(3, words);
  }

  @Test
  public void testUniqueWordCountFromSample() {
    when(stopwordRepository.isStopword("a")).thenReturn(true);
    when(stopwordRepository.isStopword("on")).thenReturn(true);
    final WordCountResultDto resultDto = wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
    Assert.assertEquals(6, resultDto.getUniqueWordCount());
    Assert.assertEquals(7, resultDto.getWordCount());
  }

  @Test
  public void testUniqueWordCountWithDuplicatedWord() {
    final WordCountResultDto resultDto = wordCounter.countWords("Humpty-Dumpty Humpty-Dumpty");
    Assert.assertEquals(1, resultDto.getUniqueWordCount());
    Assert.assertEquals(2, resultDto.getWordCount());
  }

  @Test
  public void testAverageWordLength() {
    when(stopwordRepository.isStopword("a")).thenReturn(true);
    final WordCountResultDto resultDto = wordCounter.countWords("Mary had a little lamb");
    Assert.assertEquals(4.25, resultDto.getAverageLength(), DELTA);
  }

  @Test
  public void testAverageWordLengthForEmptyStringShouldBeZero() {
    final WordCountResultDto resultDto = wordCounter.countWords("");
    Assert.assertEquals(0, resultDto.getAverageLength(), DELTA);
  }

  @Test
  public void testAverageWordLengthForSingleWordShouldEqualLength() {
    final String input = "Humpty-Dumpty";
    final WordCountResultDto resultDto = wordCounter.countWords(input);
    Assert.assertEquals(input.length(), resultDto.getAverageLength(), DELTA);
  }

  @Test
  public void testAverageWordLengthForSingleStopWordShouldBeZero() {
    when(stopwordRepository.isStopword("a")).thenReturn(true);
    final WordCountResultDto resultDto = wordCounter.countWords("a");
    Assert.assertEquals(0, resultDto.getAverageLength(), DELTA);
  }

}