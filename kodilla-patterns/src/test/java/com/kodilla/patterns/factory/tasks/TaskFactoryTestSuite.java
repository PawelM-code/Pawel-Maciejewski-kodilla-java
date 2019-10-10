package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        //Then
        Assert.assertEquals(false, driving.isTaskExecuted());
        Assert.assertEquals("Trip to Bieszczady", driving.getTaskName());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        //Then
        Assert.assertEquals("Walls Gray", painting.executeTask());
        Assert.assertEquals("Painting a room", painting.getTaskName());
    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        Assert.assertEquals(true, shopping.isTaskExecuted());
        Assert.assertEquals("Buying tires", shopping.getTaskName());
    }
}
