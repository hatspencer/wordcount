/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcount.wordcounter.input;

import java.util.Scanner;

/**
 *
 * @author Markovi
 */
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
