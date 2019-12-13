package com.kodilla.kodillapatterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Queue;

public class StudentTaskQueue implements Observable {
    private Observer mentor;
    private final Queue<String> tasks;
    private final String studentName;

    public StudentTaskQueue(Observer mentor, String studentName) {
        tasks = new ArrayDeque<>();
        this.mentor = mentor;
        this.studentName = studentName;
    }

    public Queue<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void replaceObserver(Observer observer) {
        mentor = observer;
    }

    @Override
    public void notifyObservers() {
        mentor.update(this);
    }
}
