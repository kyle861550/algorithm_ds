package oop.observer.standard;

public class MainObserver {

    public static void main(String[] args) {
        System.out.println("Apple news ----------------------");
        AppleNews appleNews = new AppleNews(330);

        appleNews.addObserver(new Person("Alien"));
        appleNews.addObserver(new Person("Pan"));
        appleNews.addObserver(new Person("Domo"));
        appleNews.notifyUpdate(340);

        System.out.println("Freedom news ----------------------");
        FreedomNews freedomNews = new FreedomNews(330);

        freedomNews.addObserver(new Person("Alien"));
        freedomNews.addObserver(new Person("Pan"));
        freedomNews.addObserver(new Person("Domo"));
        freedomNews.notifyUpdate(340);
    }
}