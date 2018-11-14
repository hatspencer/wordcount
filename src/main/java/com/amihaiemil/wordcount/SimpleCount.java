package com.amihaiemil.wordcount;

public final class SimpleCount implements WordCount {

    @Override
    public long count(final String text) {
        return text.split(" ").length;
    }
}
