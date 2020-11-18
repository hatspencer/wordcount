package com.dan.io;

import java.io.IOException;
import java.util.Scanner;

public class InputReader {

    public String readInput(String[] args) {
        if (args.length > 0) {
            String filePath = args[0];

            try {
                return FileReader.readFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }

}
