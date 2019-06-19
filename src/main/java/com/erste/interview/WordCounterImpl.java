package com.erste.interview;

import java.util.Arrays;

public class WordCounterImpl implements WordCounter {

  private final StopwordRepository stopwordRepository;

  public WordCounterImpl(StopwordRepository stopwordRepository) {
    this.stopwordRepository = stopwordRepository;
  }

  public int countWords(String input) {
    String[] elements = input.split("\\s");
    return (int) Arrays.stream(elements)
        .filter(element -> !element.isEmpty())
        .filter(element -> element.chars().allMatch(this::isLetter))
        .filter(element -> !stopwordRepository.isStopword(element))
        .count();
  }

  private boolean isLetter(int c) {
    boolean isLowercaseLetter = c >= 'a' && c <= 'z';
    boolean isUppercaseLetter = c >= 'A' && c <= 'Z';
    return isLowercaseLetter || isUppercaseLetter;
  }


}
