package com.erste.interview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.Validate;

public class StopwordRepository {

  private final Set<String> stopwords;

  public StopwordRepository(Path stopwordsFilePath) {
    Validate.isTrue(Files.isRegularFile(stopwordsFilePath), String.format("Not a regular file: %s", stopwordsFilePath));
    Validate.isTrue(Files.isReadable(stopwordsFilePath), String.format("File is not readable: %s", stopwordsFilePath));
    try (Stream<String> linesStream = Files.lines(stopwordsFilePath)) {
      this.stopwords = Collections.unmodifiableSet(linesStream.collect(Collectors.toSet()));
    } catch (IOException e) {
      throw new IllegalStateException("Stopword repository couldn't be initialized", e);
    }
  }

  public boolean isStopword(String word) {
    return stopwords.contains(word);
  }
}
