package com.example.hyphen.assingment.parser;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class CSVParserTest {

    CSVParser parser;

    @Test(expected = FileNotFoundException.class)
    public void testFetchRecords_NoCSVExists_ShouldThrowException() throws IOException {
        String csvFilePath = "src/test/testData/Outliers1.csv";
        parser = CSVParser.newCSVParser(csvFilePath);
        parser.fetchRecords();
    }

    @Test()
    public void testFetchRecords_EmptyCSVFile_ShouldPass() throws IOException {
        String csvFilePath = "src/test/testData/emptyOutliers.csv";
        parser = CSVParser.newCSVParser(csvFilePath);
        Iterable<CSVRecord> records = parser.fetchRecords();
        assertEquals(0,StreamSupport.stream(records.spliterator(), false).count());
    }

    @Test()
    public void testFetchRecords_AllGood_ShouldPass() throws IOException {
        String csvFilePath = "src/test/testData/Outliers.csv";
        parser = CSVParser.newCSVParser(csvFilePath);
        Iterable<CSVRecord> records = parser.fetchRecords();
        assertEquals(5,StreamSupport.stream(records.spliterator(), false).count());
    }
}
