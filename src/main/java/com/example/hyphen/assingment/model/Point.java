package com.example.hyphen.assingment.model;

public class Point {
    int id;
    String date;
    double price;
    public Point() {}
    public Point(int id, String date, String price) {
        this.id = id; 
        this.date = date;
        this.price = Double.parseDouble(price);
    }

    @Override
    public boolean equals(Object obj) {
        Point point  = (Point) obj;
        return id == point.getId();
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Point [date=" + date + ", price=" + price + "]";
    }

    public String toCsvString() {
        return date + "," + price;
    }
}
