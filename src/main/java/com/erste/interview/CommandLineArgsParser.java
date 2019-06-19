package com.erste.interview;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import org.apache.commons.lang3.Validate;

public class CommandLineArgsParser {

  private static final String INDEX = "-index";
  private final boolean shouldIndexBePrinted;
  private final Path inputFilePath;

  public CommandLineArgsParser(String[] args) {
    Validate.isTrue(args.length <= 2, "Too many arguments");
    shouldIndexBePrinted = Arrays.asList(args).contains(INDEX);
    if (shouldIndexBePrinted) {
      inputFilePath = Arrays.stream(args).filter(arg -> !INDEX.equals(arg)).findFirst().map(Paths::get).orElse(null);
    } else {
      inputFilePath = args.length == 1 ? Paths.get(args[0]) : null;
    }
  }

  public boolean shouldIndexBePrinted() {
    return shouldIndexBePrinted;
  }

  public Optional<Path> getInputFilePath() {
    return Optional.ofNullable(inputFilePath);
  }
}
