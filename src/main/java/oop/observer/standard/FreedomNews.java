package oop.observer.standard;

public class FreedomNews extends NewsSubject {
    private int price;

    public FreedomNews(int price) {
        this.price = price;
    }
    @Override
    public void notifyUpdate(int newPrice) {
        if(price == newPrice) {
            return;
        }

        price = newPrice - 10;

        for(Observer item : list) {
            item.changePrice(price);
        }
    }
}
