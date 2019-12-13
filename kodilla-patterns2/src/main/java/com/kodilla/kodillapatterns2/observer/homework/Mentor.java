package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(StudentTaskQueue studentTaskQueue) {
        System.out.println(username + ": New task from " + studentTaskQueue.getStudentName() + "\n" +
                " (total: " + studentTaskQueue.getTasks().size() + " tasks)");
        updateCount++;
    }
}
