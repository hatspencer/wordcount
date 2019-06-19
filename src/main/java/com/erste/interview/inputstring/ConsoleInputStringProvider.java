package com.erste.interview.inputstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputStringProvider implements InputStringProvider {

  @Override
  public String provideInputString() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.print("Enter text: ");
      return br.readLine();
    } catch (IOException e) {
      throw new RuntimeException("Couldn't read system.in", e);
    }
  }
}
