package ru.omarov.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResourcesLoader {
    private FileInputStream fis;
    private Properties properties;

    public ResourcesLoader(FileInputStream fis, Properties properties) throws IOException {
        this.fis = fis;
        this.properties = properties;
        this.getProperties().load(this.fis);
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
