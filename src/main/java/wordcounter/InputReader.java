package wordcounter;

import java.util.Scanner;

public class InputReader {

    public String readFromSystemIn() {

        Scanner inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }
}
