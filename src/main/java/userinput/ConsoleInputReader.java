package userinput;

import java.util.Scanner;

public class ConsoleInputReader implements UserInputReader {

    @Override
    public String readUserInput(){
        printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printWelcomeMessage(){
        String welcomeText = "Enter text: ";
        System.out.print(welcomeText);
    }
}
