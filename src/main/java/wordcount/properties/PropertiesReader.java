package wordcount.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties prop = null;

    public void fetchProperties() throws IOException {

        String result = "";
        InputStream inputStream = null;
        prop = new Properties();

        try {
            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public String getProperty(String key) {
        if (prop.containsKey(key)) {
            return prop.getProperty(key);
        }
        return null;
    }


}
