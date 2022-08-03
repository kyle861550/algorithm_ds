package oop.observer.jdk;

import java.util.Observable;

public class AppleNews extends Observable {
    private int price;

    public AppleNews(int price) {
        this.price = price;
    }

    public void changePrice(int newPrice) {
        if(price == newPrice) {
            return;
        }

        price = newPrice - (newPrice / 10);

        setChanged();

        notifyObservers(newPrice - (newPrice / 10));
    }

}
