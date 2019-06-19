package com.erste.interview;

public class WordCounterImpl implements WordCounter {

  public int countWords(String input) {
    int inputLength = input.length();
    int matchesFound = 0;
    boolean lastCharWasLetter = false;
    for (int i = 0; i < inputLength; i++) {
      char c = input.charAt(i);
      boolean isLetter = isLetter(c);
      if (isLetter && !lastCharWasLetter) {
        matchesFound++;
      }
      lastCharWasLetter = isLetter;
    }
    return matchesFound;
  }

  private boolean isLetter(char c) {
    boolean isLowercaseLetter = c >= 'a' && c <= 'z';
    boolean isUppercaseLetter = c >= 'A' && c <= 'Z';
    return isLowercaseLetter || isUppercaseLetter;
  }


}
