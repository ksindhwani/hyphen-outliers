package com.example.hyphen.assingment;

import java.util.List;

import com.example.hyphen.assingment.model.Point;
import com.example.hyphen.assingment.model.algorithm.DefaultOutlierStretegy;
import com.example.hyphen.assingment.model.algorithm.ZScoreOutlierStretegy;
import com.example.hyphen.assingment.model.algorithm.OutlierStretegyType;

public class OutlierDetector {

    public List<Point> detectOutliers(List<Point> dataPoints, String algorithm) throws Exception {
        List<Point> outliers = detectOutliersPoints(dataPoints, algorithm);
        return outliers;
    }

    private List<Point> detectOutliersPoints(List<Point> dataPoints, String algorithm) {
        if (algorithm.equalsIgnoreCase(OutlierStretegyType.ZSCORE.getStrategyType())) {
            return new ZScoreOutlierStretegy().detectOutliersPoints(dataPoints);
        }

        return new DefaultOutlierStretegy().detectOutliersPoints(dataPoints);
    }
}
