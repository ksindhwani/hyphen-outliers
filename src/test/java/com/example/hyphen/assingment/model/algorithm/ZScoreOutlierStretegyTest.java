package com.example.hyphen.assingment.model.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.hyphen.assingment.model.Point;

public class ZScoreOutlierStretegyTest {

    ZScoreOutlierStretegy stretegy;

    @Before
    public void setup () {
        stretegy = new ZScoreOutlierStretegy();
    }

    @Test
    public void testDetectOutliersPoint_WithNoTestPoints_ShouldPass() {
        List<Point> outliers = stretegy.detectOutliersPoints(new ArrayList<>(0));
        assertEquals(0,outliers.size());
    }

    @Test
    public void testDetectOutliersPoint_WithOneTestPoint_ShouldPass() {
        ArrayList<Point> dataPoints = new ArrayList<Point>() {
            {
                add(new Point(1,"30/01/1960","110.9257881"));
            }
        };
        List<Point> outliers = stretegy.detectOutliersPoints(dataPoints);
        assertEquals(0,outliers.size());
    }

    @Test
    public void testDetectOutliersPoint_WithTestPoints_ShouldPass() {
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
        List<Point> outliers = stretegy.detectOutliersPoints(dataPoints);
        assertEquals(1,outliers.size());
        assertEquals("15/01/1960", outliers.get(0).getDate());
        assertEquals(150.6215304, outliers.get(0).getPrice(), 0.001);
    }
}
