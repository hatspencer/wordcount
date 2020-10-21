package service;

import dto.TextAnalysisResponseDto;
import reader.ITextReader;

public class ReaderService {
    private final ITextReader textReader;

    public ReaderService(ITextReader textReader) {
        this.textReader = textReader;
    }

    public TextAnalysisResponseDto countWordsInText(final String text) {
        return new TextAnalysisResponseDto(textReader.readTextAndCountWords(text));
    }
}
