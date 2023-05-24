package com.example.hyphen.assingment.model.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.example.hyphen.assingment.model.Point;
import com.example.hyphen.assingment.model.algorithm.calculator.ZScoreCalculator;

/**
 * Class to detect outlier based on Zscore Outlier Algorithm . 
 * It used Zscore calculatr class to calulate ZScore of new points.
 */
public class ZScoreOutlierStretegy implements OutlierStrategy{

    ZScoreCalculator zScoreCalculator;
    private final double threshold = 3.3;

    public ZScoreOutlierStretegy() {
        zScoreCalculator = ZScoreCalculator.newZScoreCalculator();
    }

    @Override
    public List<Point> detectOutliersPoints(List<Point> points) {
        List<Point> outliers = new ArrayList<>();
        if(points.size() == 0 || points.size() == 1) {
            return new ArrayList<>(0);
        }
        zScoreCalculator.addDataPoint(points.get(0).getPrice());
        for(int i =1 ;i<points.size();i++) {
            Point point = points.get(i);
            if(isOutlier(point)) {
                outliers.add(point);
            }
            zScoreCalculator.addDataPoint(point.getPrice());
        }
        return outliers;
    }

    private boolean isOutlier(Point point) {
        return zScoreCalculator.getZScore(point.getPrice()) > threshold;
    }
}
