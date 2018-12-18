package com.erstegroup.hiring;

public class InputValidator {

    public static boolean validate(String text) {
         return text.matches("[a-z,A-Z ]*");
    }
}
