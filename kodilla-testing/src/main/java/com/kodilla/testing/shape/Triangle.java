package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double field;

    public Triangle(double field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        String triangle = "Triangle";
        return triangle;
    }

    @Override
    public Double getField() {
        return field;
    }
}
