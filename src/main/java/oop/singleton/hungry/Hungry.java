package oop.singleton.hungry;

public class Hungry {
    private static Hungry h = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return h;
    }

    public static void say() {
        System.out.println("Hello");
    }

}
