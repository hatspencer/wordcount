package at.erste;

import java.util.Scanner;

public class ErsteWordCounterApp {

    public static void main(String[] args) {
        System.out.print("Enter text:");
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        Integer wordCount = SplitWordCounterUtil.countWords(sentence);

        System.out.println(String.format("Number of words: %d", wordCount));
    }

}
