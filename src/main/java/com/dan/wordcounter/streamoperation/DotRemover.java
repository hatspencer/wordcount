package com.dan.wordcounter.streamoperation;

import java.util.function.Function;

public class DotRemover {

    private DotRemover() {
        // prevent init
    }

    public static Function<String, String> removeDots() {
        return (part -> part.replaceFirst("\\.", ""));
    }

}
