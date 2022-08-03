package oop.observer.standard;

public class AppleNews extends NewsSubject {

    private int price;

    public AppleNews(int price) {
        this.price = price;
    }

    @Override
    public void notifyUpdate(int newPrice) {
        if(price == newPrice) {
            return;
        }

        price = newPrice - (newPrice / 10);

        for(Observer item : list) {
            item.changePrice(price);
        }
    }

}
