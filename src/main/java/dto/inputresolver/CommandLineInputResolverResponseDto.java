package dto.inputresolver;

public class CommandLineInputResolverResponseDto {
    private final String fileName;
    private final boolean withIndex;

    public CommandLineInputResolverResponseDto(final String fileName, final boolean withIndex) {
        this.fileName = fileName;
        this.withIndex = withIndex;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isWithIndex() {
        return withIndex;
    }
}
