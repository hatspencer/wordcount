public class ProgramArgumentsParser {

    private String inputTextFilePath = null;
    private boolean indexedWords = false;
    private String dictionaryPath = null;

    public ProgramArgumentsParser(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("-index")) {
                indexedWords = true;
            } else if (arg.startsWith("-dictionary")) {
                String[] dictionaryParts = arg.split("=");
                if (dictionaryParts.length > 1) {
                    dictionaryPath = dictionaryParts[1];
                }
            } else {
                inputTextFilePath = arg;
            }
        }
    }

    public boolean isInputTextFileSet() {
        return inputTextFilePath != null && !inputTextFilePath.isEmpty();
    }

    public String getInputTextFilePath() {
        return inputTextFilePath;
    }

    public boolean isIndexedWords() {
        return indexedWords;
    }

    public boolean isIndexedDictionarySet() {
        return dictionaryPath != null && !dictionaryPath.isEmpty();
    }

    public String getDictionaryPath() {
        return dictionaryPath;
    }
}
