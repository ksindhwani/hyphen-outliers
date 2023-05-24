package com.example.hyphen.assingment.writer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hyphen.assingment.model.Point;

public class OutlierCSVWriter {
    private static final String SAMPLE_CSV_FILE = "./cleanData.csv";
    private CSVWriter writer;

    public OutlierCSVWriter() throws IOException {
        writer = new CSVWriter(SAMPLE_CSV_FILE);
    }

    public void writeToCSV(List<Point> dataPoints) throws IOException {
        String[] headers = { "Date", "Price"};
        List<String> data = convertToCSVFormatData(dataPoints);
        writer.writeDataToCSV(headers, data);
    }

    private List<String> convertToCSVFormatData(List<Point> dataPoints) {
        return dataPoints.stream().map(dataPoint -> dataPoint.toCsvString()).collect(Collectors.toList());
    }
}
