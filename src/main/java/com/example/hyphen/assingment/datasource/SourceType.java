package com.example.hyphen.assingment.datasource;

/**
 * DataSource Type Enum
 */
public enum SourceType {
    CSV("CSV"),
    DATABASE("DATABASE");

    private String sourceType;

    SourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceType() {
        return this.sourceType;
    }
}
