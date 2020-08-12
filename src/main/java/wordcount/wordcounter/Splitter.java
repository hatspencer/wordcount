/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcount.wordcounter;

/**
 *
 * @author Markovi
 */
public class Splitter {

    private static final String DELIMITER_PATTERN = "\\s+";
    
    public static String[] split(String input) {
        if (input.isEmpty()) {
            String[] emptyArray = {};
            return emptyArray;
        }
        return input.split(DELIMITER_PATTERN);
    }
    
}
