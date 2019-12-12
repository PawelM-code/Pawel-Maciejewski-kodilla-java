package com.kodilla.kodillapatterns2.observer.forum;

public interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
