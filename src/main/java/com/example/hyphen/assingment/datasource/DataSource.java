package com.example.hyphen.assingment.datasource;

import java.util.List;

import com.example.hyphen.assingment.config.ApplicationProperties;
import com.example.hyphen.assingment.model.Point;

/**
 * Abstract DataSource class to implement Factory Pattern
 */
public abstract class DataSource {

    public abstract List<Point> getDataFromSource();

    public static DataSource getDataSource(ApplicationProperties properties) throws Exception {
        if (properties.getSourceType().equalsIgnoreCase(SourceType.CSV.getSourceType())) {
            return new CSVDataSource(properties.getCSVFilePath());
        }

        throw new Exception("Invalid DataSource Type configured", null);
    }

}
