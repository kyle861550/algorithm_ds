package oop.observer.jdk;

import java.util.Observable;

public class FreedomNews extends Observable {

    private int price;

    public FreedomNews(int price) {
        this.price = price;
    }

    public void changePrice(int newPrice) {
        if(price == newPrice) {
            return;
        }

        price = newPrice - 10;

        setChanged();

        notifyObservers(newPrice - 10);
    }

}
