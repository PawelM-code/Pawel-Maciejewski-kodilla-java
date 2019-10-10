package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("Trip to Bieszczady", "Solina", "Motor");
            case PAINTING:
                return new PaintingTask("Painting a room", "Gray", "Walls");
            case SHOPPING:
                return new ShoppingTask("Buying tires", "Tires", 4);
            default:
                return null;
        }
    }
}
