package at.erste;

import at.erste.api.ConfigProperties;
import org.junit.Assert;
import org.junit.Test;

public class LoadConfigPropertiesTest {

    @Test
    public void testLoadingProperties() {
        LoadConfigPropertiesImpl loadConfigProperties = new LoadConfigPropertiesImpl();
        String pathToDictionary = "-dictionary=dictionary.txt";
        String pathToInputFile = "file.txt";
        ConfigProperties properties = loadConfigProperties.loadConfiguration(new String[]{pathToInputFile, pathToDictionary});
        Assert.assertEquals("dictionary.txt", properties.getDictionaryPath());
        Assert.assertEquals("file.txt", properties.getPathToInputPath());
    }

}
