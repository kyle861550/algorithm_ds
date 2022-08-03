package oop.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Name : " + name + ", NewsPaper: " + arg);
    }

}
