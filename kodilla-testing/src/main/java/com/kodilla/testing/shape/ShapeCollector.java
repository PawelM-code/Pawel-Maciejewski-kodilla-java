package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private Shape shape;
    private ArrayList<Shape> figures = new ArrayList<>();

    public ShapeCollector(Shape shape) {
        this.shape = shape;
    }

    public void addFigure(Shape shape){
        figures.add(shape);
    }
    public void removeFigure(Shape shape){
        figures.remove(shape);
    }
    public Shape getFigure(int n){
        return figures.get(n);
    }
    public int getFiguresQuantity(){
        return figures.size();
    }
    public void showFigures(){
        for(int i=0;i<figures.size();i++){
            System.out.println(getFigure(i).getShapeName() + " " + getFigure(i).getField());
        }
    }
}
