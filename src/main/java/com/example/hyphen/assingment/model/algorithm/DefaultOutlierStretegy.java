package com.example.hyphen.assingment.model.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.example.hyphen.assingment.model.Point;

public class DefaultOutlierStretegy implements OutlierStrategy{

    @Override
    public List<Point> detectOutliersPoints(List<Point> points) {
        return new ArrayList<>(0);
    }
    
}
