package com.erste.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordCounterImpl implements WordCounter {

  private final StopwordRepository stopwordRepository;

  public WordCounterImpl(StopwordRepository stopwordRepository) {
    this.stopwordRepository = stopwordRepository;
  }

  public WordCountResultDto countWords(String input) {
    String[] elements = input.split("[ \\t\\n]");
    final Set<String> encounteredWords = Collections.synchronizedSet(new HashSet<>());
    final IntermediateResultDto intermediateResultDto = Arrays.stream(elements)
        .filter(element -> !element.isEmpty())
        .filter(element -> element.chars().allMatch(this::isLetter))
        .filter(element -> !stopwordRepository.isStopword(element))
        .collect(IntermediateResultDto::new,
                 (acc, word) -> {
                   acc.incrementWordCount();
                   acc.incrementTotalLength(word.length());
                   if (!encounteredWords.contains(word)) { //NOSONAR
                     acc.incrementUniqueWordCount();
                     encounteredWords.add(word);
                   }
                 }, (result1, result2) -> {
              //since we don't use parallel streams we don't need a combiner to do anything
            });
    return new WordCountResultDto(intermediateResultDto.getWordCount(), intermediateResultDto.getUniqueWordCount(), intermediateResultDto.getAverageLength());
  }

  private boolean isLetter(int c) {
    boolean isLowercaseLetter = c >= 'a' && c <= 'z';
    boolean isUppercaseLetter = c >= 'A' && c <= 'Z';
    boolean isAllowedSpecialCharacter = c == '.' || c == '-';
    return isLowercaseLetter || isUppercaseLetter || isAllowedSpecialCharacter;
  }

  private static class IntermediateResultDto {

    private int wordCount = 0;
    private int uniqueWordCount = 0;
    private int totalLength;

    public int getWordCount() {
      return wordCount;
    }

    public int getUniqueWordCount() {
      return uniqueWordCount;
    }

    public int getTotalLength() {
      return totalLength;
    }

    public double getAverageLength() {
      if (wordCount == 0) {
        return 0;
      }
      return (double) totalLength / (double) wordCount;
    }

    public void incrementWordCount() {
      wordCount++;
    }

    public void incrementUniqueWordCount() {
      uniqueWordCount++;
    }

    public void incrementTotalLength(int length) {
      totalLength += length;
    }
  }


}
