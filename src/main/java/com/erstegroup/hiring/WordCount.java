package com.erstegroup.hiring;

public class WordCount {

    private WordCount() {
    }

    public static int wordCount(String text) {
        return text.split("[ ]+").length;
    }
}
