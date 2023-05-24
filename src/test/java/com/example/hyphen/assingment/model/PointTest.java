package com.example.hyphen.assingment.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
    Point point;

    @Before
    public void setup (){
        point =  new Point(1,"09/01/1960","100.4577362");
    }

    @Test
    public void testGetDate_AllGood_ShouldPass() {
        assertEquals("09/01/1960", point.getDate());
    }

    @Test
    public void testGetPrice_AllGood_ShouldPass() {
        assertEquals(100.4577362, point.getPrice(), 0.001);
    }

    @Test
    public void testToCsvString_AllGood_ShouldPass() {
        assertEquals("09/01/1960,100.4577362", point.toCsvString());

    }

    @Test
    public void testToString_AllGood_ShouldPass() {
        assertEquals("Point [date=09/01/1960, price=100.4577362]", point.toString());
    }
}
