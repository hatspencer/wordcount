package com.erste.interview;

public final class WordCountResultDto {

  private final int wordCount;
  private final int uniqueWordCount;

  public WordCountResultDto(int wordCount, int uniqueWordCount) {
    this.wordCount = wordCount;
    this.uniqueWordCount = uniqueWordCount;
  }

  public int getWordCount() {
    return wordCount;
  }

  public int getUniqueWordCount() {
    return uniqueWordCount;
  }
}
