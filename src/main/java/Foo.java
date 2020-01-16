import regexUtils.RegexParser;

import java.util.Scanner;

public class Foo {

    public static void main(String[] args){
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        RegexParser regexParser = new RegexParser(userInput);
        System.out.printf("Number of words: %d", regexParser.countWords());
        System.out.println();
    }
}
