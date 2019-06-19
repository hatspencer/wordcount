package com.erste.interview;

public final class WordCountResultDto {

  private final int wordCount;
  private final int uniqueWordCount;
  private final double averageLength;

  public WordCountResultDto(int wordCount, int uniqueWordCount, double averageLength) {
    this.wordCount = wordCount;
    this.uniqueWordCount = uniqueWordCount;
    this.averageLength = averageLength;
  }

  public int getWordCount() {
    return wordCount;
  }

  public int getUniqueWordCount() {
    return uniqueWordCount;
  }

  public double getAverageLength() {
    return averageLength;
  }
}
