public class ProgramArguments {

    private String stopWordsFilePath = null;
    private boolean indexedWords = false;
    private String dictionaryPath = null;

    public ProgramArguments(String[] args) {
        for (String arg : args) {
            if (arg.startsWith("-index")) {
                indexedWords = true;
            } else if (arg.startsWith("-dictionary")) {
                String[] dictionaryParts = arg.split("=");
                if (dictionaryParts.length > 1) {
                    dictionaryPath = dictionaryParts[1];
                }
            } else {
                stopWordsFilePath = arg;
            }
        }
    }

    public String getStopWordsFilePath() {
        return stopWordsFilePath;
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
