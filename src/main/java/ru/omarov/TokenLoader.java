package ru.omarov;

import java.io.FileInputStream;
import java.util.Properties;

public class TokenLoader {
    private FileInputStream fis;
    private Properties properties;
    private String token;

    public TokenLoader() {
    }


    public String getToken() {
        token = properties.getProperty("token");
        return token;
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
