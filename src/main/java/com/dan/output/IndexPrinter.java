package com.dan.output;

import com.dan.dictionary.Dictionary;
import com.dan.dictionary.DictionaryBuilder;
import com.dan.input.Input;
import com.dan.words.counter.UnknownWordCounterImpl;
import com.dan.words.index.WordIndexCreator;
import com.dan.words.index.WordIndexCreatorImpl;

import java.util.Collection;

public class IndexPrinter implements OutputPrinter {

    private Input input;

    public IndexPrinter(Input input) {
        this.input = input;
    }

    @Override
    public void print() {
        if (!input.hasIndex()) {
            return;
        }

        Dictionary index = createIndex(input);
        if (!input.hasDictionary()) {
            printIndex(index);
        } else {
            printIndexWithDictionary(input, index);
        }
    }

    private void printIndex(Dictionary index) {
        System.out.println("Index:");
        for (String word : index.getWords()) {
            System.out.println(word);
        }
    }

    private void printIndexWithDictionary(Input input, Dictionary index) {
        Dictionary dictionary = readDictionary(input);
        Collection<String> unknownWords = new UnknownWordCounterImpl(index, dictionary).getWords();
        int unknownWordCount = unknownWords.size();

        System.out.println("Index: (unknown: " + unknownWordCount + ")");
        for (String word : index.getWords()) {
            System.out.print(word);
            if (unknownWords.contains(word)) System.out.print("*");
            System.out.println();
        }
    }

    private Dictionary createIndex(Input input) {
        WordIndexCreator indexCreator = new WordIndexCreatorImpl(input.getTextContents());
        return indexCreator.createIndex();
    }

    private Dictionary readDictionary(Input input) {
        if (input.hasDictionary()) {
            return DictionaryBuilder.fromText(false, input.getDictionaryContents());
        } else {
            return DictionaryBuilder.empty();
        }
    }

}
