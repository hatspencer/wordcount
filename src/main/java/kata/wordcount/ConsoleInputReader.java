package kata.wordcount;

import java.util.Scanner;

class ConsoleInputReader implements InputReader {

    @Override
    public String read() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        return input.nextLine();
    }
}
