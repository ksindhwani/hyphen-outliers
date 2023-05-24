package com.example.hyphen.assingment.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVWriter {
    private Writer writer;

    public CSVWriter (String filePath) throws IOException {
        writer = new FileWriter(filePath);
    }

    public void writeDataToCSV(String[] headers, List<String> data) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
        .setHeader(headers)
        .build();

        try (CSVPrinter printer = new CSVPrinter(writer, csvFormat)) {
            printer.printRecords(data);
            printer.flush();
        }
    }
}
