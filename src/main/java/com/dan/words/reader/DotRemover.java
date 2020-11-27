package com.dan.words.reader;

import java.util.function.Function;

class DotRemover {

    private DotRemover() {
        // prevent init
    }

    public static Function<String, String> removeDots() {
        return (part -> part.replaceFirst("\\.", ""));
    }

}
