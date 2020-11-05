package at.erste.api;

public class ConfigProperties {

    private String dictionaryPath;

    private String pathToInputPath;

    public ConfigProperties(String dictionaryPath, String pathToInputPath) {
        this.dictionaryPath = dictionaryPath;
        this.pathToInputPath = pathToInputPath;
    }

    public String getDictionaryPath() {
        return dictionaryPath;
    }

    public String getPathToInputPath() {
        return pathToInputPath;
    }
}
