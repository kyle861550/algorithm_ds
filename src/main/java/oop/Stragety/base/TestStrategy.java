package oop.Stragety.base;

public class TestStrategy {

    public static void main(String[] args) {
        TravelCast travelCast;

        travelCast = new Agency();
        printCast(travelCast);

        travelCast = new SelfHelp();
        printCast(travelCast);

        travelCast = new Backpacking();
        printCast(travelCast);
    }

    public static void printCast(TravelCast travelCast) {
        System.out.println(travelCast.getClass().getSimpleName() + " Cast: " + travelCast.calCast());
    }

}
