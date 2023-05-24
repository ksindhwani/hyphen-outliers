package com.example.hyphen.assingment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.example.hyphen.assingment.model.Point;

public class OutlierRemoverTest {
    OutlierRemover remover;
    ArrayList<Point> dataPoints;

    @Before
    public void setup() {
        remover = new OutlierRemover();
        dataPoints = new ArrayList<Point>() {
            {
                add(new Point(1,"08/01/1960","101.9257881"));
                add(new Point(2,"09/01/1960","100.4577362"));    
                add(new Point(3,"10/01/1960","100.7628687"));
                add(new Point(4,"11/01/1960","101.9453853"));
                add(new Point(5,"12/01/1960","101.1339766"));
                add(new Point(6,"15/01/1960","150"));
            }
        };
    }

    @Test
    public void testRemoveOutliers_WithOutlier_ShouldPass() {
        ArrayList<Point> outliers = new ArrayList<Point>() {
            {
                add(new Point(1,"15/01/1960","150"));
            }
        };
        assertEquals(true,remover.removeOutliers(dataPoints, outliers));
        assertEquals(5, dataPoints.size());
    }

    @Test
    public void testRemoveOutliers_WithZeroOutlier_ShouldPass() {
        ArrayList<Point> outliers = new ArrayList<Point>();
        assertEquals(false,remover.removeOutliers(dataPoints, outliers));
        assertEquals(6, dataPoints.size());
    }


    @Test
    public void testRemoveOutliers_WithNoDataPoint_ShouldPass() {
        dataPoints = new ArrayList<Point>();
        ArrayList<Point> outliers = new ArrayList<Point>();
        assertEquals(false,remover.removeOutliers(dataPoints, outliers));
        assertEquals(0, dataPoints.size());
    }
}
