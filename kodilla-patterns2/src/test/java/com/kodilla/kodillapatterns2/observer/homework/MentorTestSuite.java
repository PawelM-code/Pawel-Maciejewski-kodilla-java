package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        StudentTaskQueue student1 = new StudentTaskQueue(mentor1, "Student 1");
        StudentTaskQueue student2 = new StudentTaskQueue(mentor2, "Student 2");
        StudentTaskQueue student3 = new StudentTaskQueue(mentor2, "Student 3");
        //When
        student1.addTask("task 1");
        student1.addTask("task 2");
        student1.addTask("task 3");
        student1.addTask("task 4");
        student2.addTask("task 1");
        student2.addTask("task 2");
        student3.addTask("task 1");
        //Then
        Assert.assertEquals(4, mentor1.getUpdateCount());
        Assert.assertEquals(3, mentor2.getUpdateCount());
    }

    @Test
    public void testChangeMentor() {
        //Given
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        StudentTaskQueue student1 = new StudentTaskQueue(mentor1, "Student 1");
        StudentTaskQueue student2 = new StudentTaskQueue(mentor2, "Student 2");
        StudentTaskQueue student3 = new StudentTaskQueue(mentor2, "Student 3");
        student1.addTask("task 1");
        student1.addTask("task 2");
        student1.addTask("task 3");
        student1.addTask("task 4");
        student2.addTask("task 1");
        student2.addTask("task 2");
        student3.addTask("task 1");
        //When
        student1.replaceObserver(mentor2);
        student1.addTask("New Task, after Mentor replace");
        //Then
        Assert.assertEquals(4, mentor2.getUpdateCount());
    }
}
