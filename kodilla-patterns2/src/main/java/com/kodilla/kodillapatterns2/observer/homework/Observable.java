package com.kodilla.kodillapatterns2.observer.homework;

public interface Observable {
    void replaceObserver(Observer observer);

    void notifyObservers();
}
