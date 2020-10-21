package reader;

import model.TextAnalysis;

public interface ITextReader {
    TextAnalysis readTextAndCountWords(final String text);
}
