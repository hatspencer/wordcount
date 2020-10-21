package reader;

import model.TextAnalysis;
import reader.splitter.IWordSplitter;
import reader.validator.IWordValidator;
import reader.validator.WordValidator;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TextReader implements ITextReader {
    private final IWordSplitter wordSplitter;
    private final IWordValidator wordValidator;

    public TextReader(final IWordSplitter wordSplitter, final WordValidator wordValidator) {
        this.wordSplitter = wordSplitter;
        this.wordValidator = wordValidator;
    }

    @Override
    public TextAnalysis readTextAndCountWords(final String text) {
        final List<String> totalWords = wordSplitter.splitTextIntoWords(text).stream()
                .filter(wordValidator::isValidWord)
                .collect(Collectors.toList());

        final int count = totalWords.size();
        final int uniqueOccurrenceCount = new TreeSet<>(totalWords).size();
        final double averageWordLength = totalWords
                .stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        return new TextAnalysis(count, uniqueOccurrenceCount, averageWordLength);
    }
}