package cz.rleifer.test.wordcounter.core;

import java.util.Scanner;

public class IOAccessImpl implements IOAccess{

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printInput(String output) {
        System.out.println(output);
    }
}
