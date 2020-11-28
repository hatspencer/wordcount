package com.dan.dictionary;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryBuilder {

    private DictionaryBuilder() {
        //prevent init
    }

    public static Dictionary empty() {
        return new Dictionary(Collections.emptySet(), true);
    }

    public static Dictionary fromText(boolean caseSensitive, String fileContents) {
        List<String> words = Arrays.stream(fileContents
                .split(System.lineSeparator()))
                .collect(Collectors.toList());
        return fromCollection(caseSensitive, words);
    }

    public static Dictionary fromWords(boolean caseSensitive, String... words) {
        return fromCollection(caseSensitive, Arrays.asList(words));
    }

    public static Dictionary fromCollection(Collection<String> collection) {
        return fromCollection(true, collection);
    }

    public static Dictionary fromCollection(boolean caseSensitive, Collection<String> collection) {
        collection = collection.stream()
                .filter(word -> word != null)
                .map(word -> word.trim())
                .filter(word -> !word.isEmpty())
                .map(word -> ((caseSensitive) ? word : word.toLowerCase()))
                .collect(Collectors.toList());

        return new Dictionary(collection, caseSensitive);
    }

}
