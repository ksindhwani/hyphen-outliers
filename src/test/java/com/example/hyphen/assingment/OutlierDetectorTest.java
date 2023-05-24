package com.example.hyphen.assingment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.hyphen.assingment.model.Point;
import com.example.hyphen.assingment.model.algorithm.OutlierStretegyType;

public class OutlierDetectorTest {

    OutlierDetector detector;
    @Before
    public void setup() {
        detector = new OutlierDetector();
    }

    @Test
    public void testDetectOutliers_AllGood_ShouldPass() throws Exception {
        ArrayList<Point> dataPoints = new ArrayList<Point>() {
            {
                add(new Point(1,"08/01/1960","101.9257881"));
                add(new Point(2,"09/01/1960","100.4577362"));    
                add(new Point(3,"10/01/1960","100.7628687"));
                add(new Point(4,"11/01/1960","101.9453853"));
                add(new Point(5,"12/01/1960","101.1339766"));
                add(new Point(6,"15/01/1960","150.6215304"));
            }
        };
        List<Point> outliers = detector.detectOutliers(dataPoints,OutlierStretegyType.ZSCORE.getStrategyType());
        assertEquals(1,outliers.size());
        assertEquals("15/01/1960", outliers.get(0).getDate());
        assertEquals(150.6215304, outliers.get(0).getPrice(), 0.001);
    }

    @Test
    public void testDetectOutliers_WithNoTestPoints_ShouldPass() throws Exception {
        List<Point> outliers =  detector.detectOutliers(new ArrayList<>(0), OutlierStretegyType.ZSCORE.getStrategyType());
        assertEquals(0,outliers.size());
    }

    @Test
    public void testDetectOutliers_WithOneTestPoint_ShouldPass() throws Exception {
        ArrayList<Point> dataPoints = new ArrayList<Point>() {
            {
                add(new Point(1,"30/01/1960","110.9257881"));
            }
        };
        List<Point> outliers = detector.detectOutliers(dataPoints,OutlierStretegyType.ZSCORE.getStrategyType());
        assertEquals(0,outliers.size());
    }
}
