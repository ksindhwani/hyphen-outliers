package com.example.hyphen.assingment.config;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationPropertiesTest {
    ApplicationProperties properties;
    String propertiesFilepath;

    @Test
    public void testGetAlgorithm_AllGood_ShouldPass() throws IOException {
        propertiesFilepath = "/application.properties";
        properties = new ApplicationProperties(propertiesFilepath);
        Assert.assertEquals("z-score", properties.getAlgorithm().toLowerCase());
    }

    @Test(expected = NullPointerException.class)
    public void testGetAlgorithm_PropertyFileNotExists_ShouldThrowNullPointerException() throws IOException {
        propertiesFilepath = "/application1.properties";
        new ApplicationProperties(propertiesFilepath);
        
    }

    @Test
    public void testGetCSVFilePath_AllGood_ShouldPass() throws IOException {
        propertiesFilepath = "/application.properties";
        properties = new ApplicationProperties(propertiesFilepath);
        Assert.assertEquals("src/main/resources/outliers.csv", properties.getCSVFilePath().toLowerCase());

    }

    @Test(expected = NullPointerException.class)
    public void testGetCSVFilePath_PropertyFileNotExists_ShouldThrowNullPointerException() throws IOException {
        propertiesFilepath = "/application1.properties";
        new ApplicationProperties(propertiesFilepath);

    }

    @Test
    public void testGetSourceType() throws IOException {
        propertiesFilepath = "/application.properties";
        properties = new ApplicationProperties(propertiesFilepath);
        Assert.assertEquals("csv", properties.getSourceType().toLowerCase());
    }

    @Test(expected = NullPointerException.class)
    public void testGetSourceType_PropertyFileNotExists_ShouldThrowNullPointerException() throws IOException {
        propertiesFilepath = "/application1.properties";
        new ApplicationProperties(propertiesFilepath);
    }
}
