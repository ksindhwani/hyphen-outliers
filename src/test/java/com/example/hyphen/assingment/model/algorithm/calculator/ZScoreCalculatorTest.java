package com.example.hyphen.assingment.model.algorithm.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZScoreCalculatorTest {

    ZScoreCalculator zScoreCalculator;

    @Before
    public void setup() {
        zScoreCalculator = ZScoreCalculator.newZScoreCalculator();
    }

    @Test
    public void testGetZScore_WithNoPoints_ShouldPass() {
        assertEquals(Double.NaN,zScoreCalculator.getZScore(1.0),0.001);
    }

    @Test
    public void testGetZScore_WithPoints_ShouldPass() {
        zScoreCalculator.addDataPoint(1.0);
        zScoreCalculator.addDataPoint(2.0);
        zScoreCalculator.addDataPoint(3.0);
        assertEquals(2.0,zScoreCalculator.getZScore(4.0),0.001);
    }
}
