package com.erste.interview.inputstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.Validate;

public class FileInputStringProvider implements InputStringProvider {

  private final Path inputFilePath;

  public FileInputStringProvider(Path inputFilePath) {
    Validate.isTrue(Files.isRegularFile(inputFilePath), inputFilePath + " is not a regular file");
    Validate.isTrue(Files.isReadable(inputFilePath), inputFilePath + " is not readable");
    this.inputFilePath = inputFilePath;
  }

  @Override
  public String provideInputString() {
    try (Stream<String> lines = Files.lines(inputFilePath)) {
      return lines.collect(Collectors.joining(" "));
    } catch (IOException e) {
      throw new IllegalStateException("Could not read the input file " + inputFilePath, e);
    }
  }
}
