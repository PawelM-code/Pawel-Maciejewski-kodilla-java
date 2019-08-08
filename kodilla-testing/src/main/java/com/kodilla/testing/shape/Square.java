package com.kodilla.testing.shape;

public class Square implements Shape {
    private double field;

    public Square(double field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        String square = "Square";
        return square;
    }

    @Override
    public Double getField() {
        return field;
    }
}
