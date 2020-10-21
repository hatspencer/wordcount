package reader;

import dto.TextAnalysisResponseDto;

public interface ITextReader {
    TextAnalysisResponseDto readTextAndCountWords(final String text);
}
