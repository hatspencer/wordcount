package dto.inputresolver;

public class CommandLineInputResolverResponseDto {
    private final String fileName;
    private final boolean withIndex;
    private final String dictionaryFileName;

    public CommandLineInputResolverResponseDto(final String fileName, final boolean withIndex, final String dictionaryFileName) {
        this.fileName = fileName;
        this.withIndex = withIndex;
        this.dictionaryFileName = dictionaryFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isWithIndex() {
        return withIndex;
    }

    public String getDictionaryFileName() {
        return dictionaryFileName;
    }
}
