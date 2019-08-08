package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double field;

    public Circle(double field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        String circle = "Circle";
        return circle;
    }

    @Override
    public Double getField() {
        return field;
    }
}
