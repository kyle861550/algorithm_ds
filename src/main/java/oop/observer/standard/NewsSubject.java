package oop.observer.standard;

import java.util.ArrayList;
import java.util.List;

public abstract class NewsSubject {

    protected final List<Observer> list = new ArrayList<>();

    public void addObserver(Observer observer) {
        list.add(observer);
    }

    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    public abstract void notifyUpdate(int newPrice);
}
