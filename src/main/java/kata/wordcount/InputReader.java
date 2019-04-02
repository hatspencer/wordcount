package kata.wordcount;

import java.util.Scanner;

class InputReader {

    String getInput() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        return input.nextLine();
    }
}
