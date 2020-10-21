package reader;

import reader.splitter.IWordSplitter;
import reader.validator.IWordValidator;
import reader.validator.WordValidator;

import java.util.List;

public class TextReader implements ITextReader {
    private final IWordSplitter wordSplitter;
    private final IWordValidator wordValidator;

    public TextReader(final IWordSplitter wordSplitter, final WordValidator wordValidator) {
        this.wordSplitter = wordSplitter;
        this.wordValidator = wordValidator;
    }

    @Override
    public int readTextAndCountWords(final String text) {
        final List<String> wordCandidates = wordSplitter.splitTextIntoWords(text);

        return (int) wordCandidates.stream()
            .filter(wordValidator::isValidWord)
                .count();
    }
}
