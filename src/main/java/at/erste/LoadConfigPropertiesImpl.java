package at.erste;

import at.erste.api.ConfigProperties;

public class LoadConfigPropertiesImpl implements LoadConfigProperties {

    @Override
    public ConfigProperties loadConfiguration(String[] args) {
        String pathToDictionary = null;
        String pathToInputFile = null;
        for (String arg : args) {
            if (arg.startsWith("-dictionary=")){
                pathToDictionary = arg.replaceAll("-dictionary=", "");
            } else {
                pathToInputFile = arg;
            }
        }
        return new ConfigProperties(pathToDictionary, pathToInputFile);
    }
}
