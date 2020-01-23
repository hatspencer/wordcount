package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class UserInterfaceTest {

    @Test
    public void initialiseUserInputShouldPrintExpectedPrompt() throws IOException {
        File file = new File("uiTest.txt");
        String expectedPrompt = "Enter text: ";
        UserInterface userInterface = new UserInterface(new PrintStream(file));
        Path path = FileSystems.getDefault().getPath(file.getName()).toAbsolutePath();
        userInterface.initialiseUserInterface();
        Assertions.assertEquals(expectedPrompt, Files.readAllLines(path).get(0));
    }
}
