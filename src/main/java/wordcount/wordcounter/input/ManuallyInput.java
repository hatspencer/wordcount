package wordcount.wordcounter.input;

import java.util.Scanner;

public class ManuallyInput implements Input {

    @Override
    public String getInputData() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        System.out.println("["+input+"]");
        return input;
    }
}
