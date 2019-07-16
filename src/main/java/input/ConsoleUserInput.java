package input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInput extends UsersInput {
    public List<String> getInput() {
        System.out.print("Enter text: ");
        return InputUtils.readFromConsole();
    }
}
