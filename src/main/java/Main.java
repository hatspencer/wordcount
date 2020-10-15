import solver.WordCounter;

import java.util.Scanner;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your text for word counting.");
        String userInput = scanner.nextLine();

        WordCounter wordCounter = new WordCounter();
        System.out.println("Number of words: " + wordCounter.countWords(userInput));
    }
}
