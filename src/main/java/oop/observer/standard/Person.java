package oop.observer.standard;

public class Person implements Observer {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void changePrice(int newPrize) {
        System.out.println("Name : " + name + ", NewsPaper: " + newPrize);
    } 

}
