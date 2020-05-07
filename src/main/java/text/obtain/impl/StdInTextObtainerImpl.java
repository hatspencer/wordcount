package text.obtain.impl;

import java.util.Scanner;

import text.obtain.TextObtainer;

public class StdInTextObtainerImpl implements TextObtainer {

    @Override
    public String obtainText() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");
        return myObj.nextLine();
    }
}
