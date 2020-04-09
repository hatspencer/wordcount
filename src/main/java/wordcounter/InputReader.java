package wordcounter;

import java.util.Scanner;

public class InputReader {

    public String readFromSystemIn(String welcomeMessage) {

        System.out.print(welcomeMessage);
        Scanner inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }
}
