package ru.omarov;

import java.io.FileInputStream;
import java.util.Properties;

public class ResourcesLoader {
    private FileInputStream fis;
    private Properties properties;

    public ResourcesLoader() {
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
