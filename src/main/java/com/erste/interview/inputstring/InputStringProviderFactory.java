package com.erste.interview.inputstring;

import java.nio.file.Paths;

public class InputStringProviderFactory {

  private final String[] consoleArgs;

  public InputStringProviderFactory(String[] consoleArgs) {
    this.consoleArgs = consoleArgs;
  }

  public InputStringProvider createInputStringProvider() {
    switch (consoleArgs.length) {
      case 0:
        return new ConsoleInputStringProvider();
      case 1:
        return new FileInputStringProvider(Paths.get(consoleArgs[0]));
      default:
        throw new IllegalArgumentException("Console args can have at most 1 argument");
    }
  }

}
