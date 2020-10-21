package reader;

import model.TextAnalysis;
import reader.splitter.IWordSplitter;
import reader.validator.IWordValidator;
import reader.validator.WordValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextReader implements ITextReader {
    private final IWordSplitter wordSplitter;
    private final IWordValidator wordValidator;
    private final List<String> knownWords;

    public TextReader(final IWordSplitter wordSplitter, final WordValidator wordValidator) {
        this.wordSplitter = wordSplitter;
        this.wordValidator = wordValidator;
        knownWords = new ArrayList<>();
    }

    public TextReader(final IWordSplitter wordSplitter, final WordValidator wordValidator, final List<String> knownWords) {
        this.wordSplitter = wordSplitter;
        this.wordValidator = wordValidator;
        this.knownWords = knownWords;
    }

    @Override
    public TextAnalysis readTextAndCountWords(final String text) {
        final List<String> totalWords = wordSplitter.splitTextIntoWords(text).stream()
                .filter(wordValidator::isValidWord)
                .collect(Collectors.toList());

        final int count = totalWords.size();
        final double averageWordLength = totalWords
                .stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        final TreeSet<String> uniqueWordsSet = new TreeSet<>(totalWords);
        final int uniqueOccurrenceCount = uniqueWordsSet.size();
        final List<String> unknownWords = uniqueWordsSet
                .stream()
                .filter(word -> !knownWords.contains(word))
                .collect(Collectors.toList());
        final int numberOfUnknownWords = unknownWords.size();

        final String index = String.join("\n", uniqueWordsSet);
        final String indexWithUnknownWords = uniqueWordsSet
                .stream()
                .sorted(String::compareToIgnoreCase)
                .map(mapWordToIndexWithUnknownWordsFormat())
                .collect(Collectors.joining());

        return new TextAnalysis(count, uniqueOccurrenceCount, averageWordLength, index, numberOfUnknownWords, indexWithUnknownWords);
    }

    private Function<String, String> mapWordToIndexWithUnknownWordsFormat() {
        return word -> {
            if (!knownWords.contains(word)) {
                return word + "*\n";
            }
            return word + "\n";
        };
    }
}