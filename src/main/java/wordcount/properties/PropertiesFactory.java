package wordcount.properties;

import java.io.IOException;

public class PropertiesFactory {

    public static PropertiesReader getPropertiesReader() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader();
        propertiesReader.fetchProperties();
        return propertiesReader;
    }

}
