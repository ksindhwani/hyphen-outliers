package com.example.hyphen.assingment.config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    private final Properties properties;

    public ApplicationProperties(String filePath) throws IOException {
        properties = new Properties();
        properties.load(ApplicationProperties.class.getResourceAsStream(filePath));
    }
    
    public String getSourceType() {
        return properties.getProperty("sourcetype");
    }

    public String getAlgorithm() {
        return properties.getProperty("algorithm");
    }

    public String getCSVFilePath() {
        return properties.getProperty("csvFilePath");
    }
}
