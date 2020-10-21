package reader;

import dto.TextAnalysisResponseDto;
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
    public TextAnalysisResponseDto readTextAndCountWords(final String text) {
        final List<String> totalWords = wordSplitter.splitTextIntoWords(text).stream()
                .filter(wordValidator::isValidWord)
                .collect(Collectors.toList());

        final int count = totalWords.size();
        final int uniqueOccurrenceCount = new TreeSet<>(totalWords).size();

        return new TextAnalysisResponseDto(count, uniqueOccurrenceCount);
    }
}