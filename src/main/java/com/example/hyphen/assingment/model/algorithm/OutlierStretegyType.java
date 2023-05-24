package com.example.hyphen.assingment.model.algorithm;

public enum OutlierStretegyType {
    ZSCORE("z-score"),
    KUNAL("kunal");

    private String strategyType;
    OutlierStretegyType (String strategyType) {
        this.strategyType = strategyType;
    }

    public String getStrategyType() {
        return this.strategyType;
    }
}
