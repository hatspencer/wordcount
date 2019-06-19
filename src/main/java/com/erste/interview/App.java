package com.erste.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

  public static void main(String[] args) {
    WordCounterImpl wordCounter = new WordCounterImpl();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print("Enter text: ");
      String line = br.readLine();
      System.out.println("Number of words: " + wordCounter.countWords(line));
    } catch (IOException e) {
      throw new RuntimeException("Couldn't read system.in", e);
    }

  }

}
