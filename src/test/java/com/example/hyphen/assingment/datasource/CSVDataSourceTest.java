package com.example.hyphen.assingment.datasource;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.example.hyphen.assingment.model.Point;

public class CSVDataSourceTest {

    CSVDataSource dataSource;

    @Test(expected = FileNotFoundException.class)
    public void testGetDataFromSource_CSVFileNotExists_ShouldThrowException() throws FileNotFoundException {
        String csvFilePath = "src/test/testData/Outliers1.csv";
        dataSource = new CSVDataSource(csvFilePath);
       dataSource.getDataFromSource();
    }

    @Test
    public void testGetDataFromSource_AllGood_ShouldPass() throws FileNotFoundException {
        String csvFilePath = "src/test/testData/Outliers.csv";
        dataSource = new CSVDataSource(csvFilePath);
        List<Point> datapoints = dataSource.getDataFromSource();
        assertEquals(5,datapoints.size());
    }

    @Test
    public void testGetDataFromSource_EmptyFile_ShouldPass() throws FileNotFoundException {
        String csvFilePath = "src/test/testData/emptyOutliers.csv";
        dataSource = new CSVDataSource(csvFilePath);
        List<Point> datapoints = dataSource.getDataFromSource();
        assertEquals(0,datapoints.size());
    }

    @Test(expected = NumberFormatException.class)
    public void testGetDataFromSource_badFile_ShouldPass() throws FileNotFoundException {
        String csvFilePath = "src/test/testData/badOutliers.csv";
        dataSource = new CSVDataSource(csvFilePath);
        List<Point> datapoints = dataSource.getDataFromSource();
        assertEquals(0,datapoints.size());
    }
}
