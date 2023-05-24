package com.example.hyphen.assingment.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVParser {

    Reader reader;

    private CSVParser(String filePath) throws FileNotFoundException {
        reader = new FileReader(filePath);
    }

    public static CSVParser newCSVParser(String filePath) throws FileNotFoundException {
        return new CSVParser(filePath);
    }

    public Iterable<CSVRecord> fetchRecords() throws IOException {
        /* Skipping the first record as its a header in csv file */
        return CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build()
                .parse(reader);
    }
}
