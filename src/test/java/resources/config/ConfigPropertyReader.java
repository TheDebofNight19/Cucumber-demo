package resources.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertyReader implements ConfigReader {

    private Properties properties = new Properties();

    public ConfigPropertyReader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream = contextClassLoader.getResourceAsStream("config/config.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
        @Override
        public String getValue (String key){
            return properties.getProperty(key);
        }
    }