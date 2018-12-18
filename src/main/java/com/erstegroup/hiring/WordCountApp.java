package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountApp {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        String text = br.readLine();
        if (text.matches("[a-z,A-Z ]*")) {
            System.out.println("Number of words: " + WordCount.wordCount(text));
        } else {
            System.err.println("Error input");
        }
    }
}
