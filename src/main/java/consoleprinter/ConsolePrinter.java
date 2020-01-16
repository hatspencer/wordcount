package consoleprinter;

import regexutils.RegexParser;

import java.util.Scanner;

public class ConsolePrinter {

    String welcomeText;
    String outputText;

    public ConsolePrinter(String welcomeText, String outputText){
        this.welcomeText = welcomeText;
        this.outputText = outputText;
    }

    public void print(){
        System.out.print(this.welcomeText);
        Scanner scanner = new Scanner(System.in);
        RegexParser regexParser = new RegexParser(scanner.nextLine());
        System.out.printf("%s%d", this.outputText, regexParser.countWords());
        System.out.println();
    }
}
