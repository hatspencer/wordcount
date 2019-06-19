package com.erste.interview;

import java.nio.file.Path;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class CommandLineArgsParserTest {

  @Test
  public void testEmptyArgs() {
    final CommandLineArgsParser parser = new CommandLineArgsParser(new String[]{});
    Assert.assertFalse(parser.shouldIndexBePrinted());
    Assert.assertEquals(Optional.empty(), parser.getInputFilePath());
  }

  @Test
  public void testIndexWithNoFile() {
    final CommandLineArgsParser parser = new CommandLineArgsParser(new String[]{"-index"});
    Assert.assertTrue(parser.shouldIndexBePrinted());
    Assert.assertEquals(Optional.empty(), parser.getInputFilePath());
  }

  @Test
  public void testFileWithoutIndex() {
    final String pathString = "some-file.txt"; //NOSONAR
    final CommandLineArgsParser parser = new CommandLineArgsParser(new String[]{pathString});
    Assert.assertFalse(parser.shouldIndexBePrinted());
    Assert.assertEquals(Optional.of(pathString), parser.getInputFilePath().map(Path::toString));
  }

  @Test
  public void testFileWithIndex() {
    final String pathString = "some-file.txt"; //NOSONAR
    final CommandLineArgsParser parser = new CommandLineArgsParser(new String[]{pathString, "-index"});
    Assert.assertTrue(parser.shouldIndexBePrinted());
    Assert.assertEquals(Optional.of(pathString), parser.getInputFilePath().map(Path::toString));
    final CommandLineArgsParser parser2 = new CommandLineArgsParser(new String[]{"-index", pathString});
    Assert.assertTrue(parser2.shouldIndexBePrinted());
    Assert.assertEquals(Optional.of(pathString), parser2.getInputFilePath().map(Path::toString));
  }

}